package servidor;
import java.util.Random;

public class monitorImpl extends monitorPOA {
	String nombre_valores;
	
	monitorImpl(){
		nombre_valores=new String("");	
	}
	
	@Override
	public String agregar(String valor){
		if(nombre_valores.isEmpty()==true){
			nombre_valores=valor;	
		}else{
			if(nombre_valores.contains(valor)==false)
				nombre_valores=nombre_valores+"-"+valor;
		}
		return cargar_valores();
	}
	@Override
        public String borrar(String valor){
		if(nombre_valores.isEmpty()==false){
			String []valores=nombre_valores.split("-");
                	String aux=new String("");
                	for(int i=0;i<valores.length;i++){
				if(valores[i].equals(valor)==false){
                        		aux=aux+valores[i]+"-";
                        	}
                	}
			nombre_valores=null;
			nombre_valores=aux;
		}	
		return cargar_valores();
	}
        @Override
        public String mostrar(){
		return cargar_valores();
	}

	private String cargar_valores(){
		String aux=new String("");
		if(nombre_valores.isEmpty()==false){
			Random rn = new Random();
			String []valores=nombre_valores.split("-");
			for(int i=0;i<valores.length;i++){
				aux=aux+valores[i]+"$"+
					String.valueOf(rn.nextInt(100))+"-";		
			}
		}		
		return aux;
	}
}
