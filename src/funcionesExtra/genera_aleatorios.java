package funcionesExtra;

public class genera_aleatorios {

    private int maximo;
    private int minimo=0;
    private int n_elementos=0;
    private boolean enc;
    private int alea;

    public genera_aleatorios(int n_jugadores){
        maximo=n_jugadores;
    }

    int[] posiciones= new int[maximo];

    public int[] dame_aleatorios(){
        
        int posiciones[]=new int[maximo];

        while(n_elementos<maximo){
            enc=false;
            alea=genera_num_aleatorios(maximo, minimo);
            for(int z=0;z<posiciones.length && !enc;z++){
                if(alea==posiciones[z]){
                    enc=true;
                }
            }
            if(!enc){
                posiciones[n_elementos]=alea;
                n_elementos++;
            }
        }
        return posiciones;
    }


    private static int genera_num_aleatorios(int minimo, int maximo){
        int num= (int) Math.floor(Math.random() * (minimo-maximo+1)+(maximo));
        return num;
    }
}
