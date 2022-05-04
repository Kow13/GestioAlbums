/*  La clase GestioAlbums és la classe Main, on es trobarà el programa principal
 *  i el el que es mostrarà per pantalla
 */
package gestioalbums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author marcferrerfernandez
 */
public class GestioAlbums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean sortir = false;
        int opcio;
        while (!sortir){
            menu();
            opcio = leerNum("Escriu la opció: ");
            if (opcio > 5){
                InsercioDadesException e = new InsercioDadesException();
            }
            switch(opcio){
                case 0:
                    sortir = true;
                    break;
                case 1:
                    metodo1();
                    break;
                case 2: 
                    metodo2();
                    break;
                case 3:
                    metodo3();
                    break;
                case 4:
                    metodo4();
                    break;
                case 5:
                    metodo5();
                    break;
            }
        }
    }
    
    private static void menu(){
        System.out.println("Gestió dels discs que s'haurien d'escoltar");
        System.out.println("\n" + "1. Veure el contingut del fitxer de text i inicialitza fitxer de vots");
        System.out.println("2. Veure el contingut del fitxer de vots d'accès aleatori");
        System.out.println("3. Un vot manual");
        System.out.println("4. Simula vots aleatoris");
        System.out.println("5. Calcula el millor àlbum");
        System.out.println("0. Sortir");
    }
    
    private static void metodo1(){ //Aquest mètode llegueix el fitxer de text en termes d'albums i inicialitza el fitxer de vots
        FO fa = new FO("albumes.txt");
        fa.obrir();
        fa.leerAlbum();
        fa.tancar();
    }  
    
    private static void metodo2(){ //Aquest mètode mostra per pantalla el contigut del fitxer de vots
        FitxerAlbums fv = new FitxerAlbums("votos.dat","rw");
        fv.mostrarContenido();
    }
    
    private static void metodo3(){ //Aquest mètode permet votar un album
        FitxerAlbums fv = new FitxerAlbums("votos.dat","rw");
        int numDisc = leerNum("Num de disc que vols votar [1..100]? ");
        if (numDisc > 100){
            InsercioDadesException e = new InsercioDadesException();            
        }
        int numVot = leerNum("Puntuació [1..10]: ");
        if (numVot > 10){
            InsercioDadesException e = new InsercioDadesException();            
        }        
        fv.añadirVoto(numDisc,numVot);       
    }
    
    private static void metodo4(){ //Aquest mètode realitza una simulació de vots generats aleatoriament
        FitxerAlbums fv = new FitxerAlbums("votos.dat","rw");         
        Random rm = new Random();
        String s = "";
        System.out.println("Votació aleatoria");
        int rep = leerNum("Nombre de votacions que vols generar [1..100]? ");
        if (rep > 100){
            InsercioDadesException e = new InsercioDadesException();            
        }
        for (int i = 0; i < rep; i++){
            s += "Vot: " + (i+1);
            for (int j = 0; j < 10; j++){
                int numDisc = rm.nextInt(1, 100);
                fv.añadirVoto(numDisc, j+1);
                s += "[#" + numDisc + " - " + (j+1) + "] ";
            }
            s += "\n";
        }
        System.out.println(s);
    }
    
    private static void metodo5(){ //Aquest mètode mostra quin és el millor album segons els vots
        FitxerAlbums fv = new FitxerAlbums("votos.dat","rw");        
        album r = new album();
        System.out.println("El millor album és: ");
        r = fv.millorAlbum();
        System.out.println(r.toString2());
    }       
    

   
        
    
       
    
    
    private static int leerNum(String message) {
        int num;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message);
            num = Integer.parseInt(in.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
        return num;
    }
    
}
