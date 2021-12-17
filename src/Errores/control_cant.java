package Errores;

public class control_cant {
	

	public control_cant() {
	}
	
	public  void examinaNumero (int num_jug) throws error_longitud{
		
		
		if(num_jug<5 ||num_jug>18) {
			
			throw new error_longitud ("Error el numero de jugadores no es valido.");
		}
	}
}
