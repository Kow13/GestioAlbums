/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioalbums;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author marcferrerfernandez
 */
public class FitxerAlbums {
    private RandomAccessFile f;
    private File file;
    final int tamañoAlbum = 332;
    
    public FitxerAlbums(String name,String option){
        try {
            file = new File(name);
            if (!file.exists()){
                file.createNewFile();
            }
            f = new RandomAccessFile(file,option);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void añadirAlbum(album r){
        try {
            f.seek(f.length());
            f.writeInt(r.getNum());
            f.writeInt(r.getVotos());
            f.writeChars(rellenarBlancos(r.getTitol()));
            f.writeChars(rellenarBlancos(r.getArtista()));
            f.writeInt(r.getAny());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarContenido(){
        try{
            f.seek(0);
            album imp = new album();
            while(f.getFilePointer()  < f.length()){
                imp.setNum(f.readInt());
                imp.setVotos(f.readInt());
                String titol = "";
                for (int i = 0; i < 80; ++i) {
                    titol += f.readChar();
                }
                imp.setTitol(titol);
                String artista = "";
                for (int i = 0; i<80; i++){
                    artista += f.readChar();
                }
                imp.setArtista(artista);
                imp.setAny(f.readInt());
                
                System.out.println(imp.toString2());
            }
        }catch(IOException e){
            System.out.println("ERROR" + e.getMessage());
        }
    }
    
    public void añadirVoto(int numDisc, int numVot){
        try{
            int votosEx;
            f.seek(0);
            f.skipBytes(tamañoAlbum * (numDisc-1));
            f.skipBytes(4);
            votosEx = f.readInt();
            f.seek(0);
            f.skipBytes(tamañoAlbum * (numDisc-1));
            f.skipBytes(4);
            f.writeInt(numVot + votosEx);
        } catch (IOException e){
            System.out.println("ERROR " + e.getMessage());
        }
        
    }
    
    public album millorAlbum(){

        album r = new album();
        try{
            f.seek(0);
            f.skipBytes(4);
            int numV = f.readInt();
            int millorAl = numV;
            int pos = 1;
            for (int i = 2; i < 101; i++){
                f.seek(0);
                f.skipBytes(tamañoAlbum * (i-1));
                f.skipBytes(4);
                numV = f.readInt();
                
                if (numV > millorAl){
                    millorAl = numV;
                    pos = i;
                }
            }
            r = accedirAlbumAmbPos(pos);


        } catch(IOException e){
            System.out.println("ERROR" + e.getMessage());
        }
        return r;
    }
    
    private album accedirAlbumAmbPos(int pos){
        album r = new album();
        try{
            f.seek(0);
            f.skipBytes(tamañoAlbum * (pos - 1));
            r.setNum(f.readInt());
            r.setVotos(f.readInt());
            String titol = "";
            for (int i = 0; i < 80; ++i) {
                titol += f.readChar();
            }
            r.setTitol(titol);
            String artista = "";
            for (int i = 0; i<80; i++){
                artista += f.readChar();
            }
            r.setArtista(artista);
            r.setAny(f.readInt());
            
        } catch(IOException e){
            System.out.println("ERROR" + e.getMessage());
        }
        return r;
    }
    
    private String rellenarBlancos(String s){
        for (int i = s.length(); i < 80; i++){
            s += " ";
        }
        return s;
    }
}

