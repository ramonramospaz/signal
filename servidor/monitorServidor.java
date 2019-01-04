package servidor;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import java.io.*;

public class monitorServidor {
	public static void main(String[] args){
		try{
			ORB orb = ORB.init(args,null);
                        org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
                        POA rootPoa =POAHelper.narrow(obj);
                        rootPoa.the_POAManager().activate();
                        monitorImpl monimpl = new monitorImpl();
                        obj =rootPoa.servant_to_reference(monimpl);
                        FileWriter out =new FileWriter("objmon.ref");
                        out.write(orb.object_to_string(obj));
                        out.close();
                        System.out.println("Esperando clientes..");
                        orb.run();

			
		}
		catch(Exception e){
			e.printStackTrace();	
		}
	}
} 
