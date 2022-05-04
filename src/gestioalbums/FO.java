/*
 * Aquesta classe gestiona el fitxer de text en el que trobam la informació dels albums
 */
package gestioalbums;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author marcferrerfernandez
 */
public class FO {
    private FileReader fic;
    private BufferedReader reader;
    private String nom;
    
    public FO(String n){
        nom = n;
    }
    
    public void obrir() {
        try {
            fic = new FileReader(nom.toString());
            reader = new BufferedReader(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
   public String llegirLinea(){
        String s = null;
        try{
            s = reader.readLine();
        }catch (IOException e){
            System.out.println("ERROR" + e.getMessage());
        }
        return s;
    }
    
    public void leerAlbum(){ //aquest mètode llegueix els 100 albums del fitxer de text, lleguint linea per linea, afegint atributs a un album
        FitxerAlbums fv = new FitxerAlbums("votos.dat","rw");
        String s;
        int votos = 0;
        album r = new album();
        for (int i = 0; i<100; i++){
            s = llegirLinea();
            r.setNum(Integer.parseInt(s));
            s = llegirLinea();
            r.setAny(Integer.parseInt(s));
            s = llegirLinea();
            r.setTitol(s);
            s = llegirLinea();
            r.setArtista(s);
            s = llegirLinea();
            r.setTipus(s);
            s = llegirLinea();
            r.setEstrelles(Float.parseFloat(s));
            s = llegirLinea();
            r.setEdicions(Integer.parseInt(s));
            r.setVotos(votos);            
            System.out.println(r.toString1());
            fv.añadirAlbum(r);
        }
    }
    
    
    public void tancar() {
        try {
            reader.close();
            fic.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fic.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

