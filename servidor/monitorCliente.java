package servidor;
import org.omg.CORBA.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class monitorCliente {
	static public monitor mon;
	
	monitorCliente(String []args){
		try{
			ORB orb = ORB.init(args, null);
                        String ior = new BufferedReader(new FileReader("objmon.ref")).readLine();
                        org.omg.CORBA.Object obj = orb.string_to_object(ior);
                        mon = monitorHelper.narrow(obj);
		
		}catch(Exception e){
                        System.out.println("Error:"+e.getMessage());
                }
	}
	
	public static void main(String[] args){
		try{
			monitorCliente srv = new monitorCliente(args);
			ServerSocket servidor = new ServerSocket(8888);
			String res=new String("");
			while(true){
				System.out.println("Esperando conexion de servidor web");
				Socket cliente = servidor.accept();
				PrintWriter salida = new PrintWriter(cliente.getOutputStream());
                        	BufferedReader entrada = new BufferedReader(
                                        new InputStreamReader(cliente.getInputStream()));
				String pre=entrada.readLine();
				System.out.println("La cadena es la siguiente:"+pre);
				String []aux = pre.split("-");
				System.out.println("Recibiendo Datos");
				if(aux.length==2){
					if(aux[0].equals("a")==true){
						if(aux[1].isEmpty()==false){
							res=mon.agregar(aux[1]);
						}
					}
					if(aux[0].equals("b")==true){
						if(aux[1].isEmpty()==false){
							res=mon.borrar(aux[1]);
						}
					}
				}
				else{
					if(aux[0].equals("m")==true){
						res=mon.mostrar();
					}
				}
				System.out.println("El resultado es:"+res);					salida.println(res);
                                salida.flush();	
				salida.close();
				entrada.close();
			}

                }catch(Exception e){
                        System.out.println("Error:"+e.getMessage());
                }

		
	}
} 
