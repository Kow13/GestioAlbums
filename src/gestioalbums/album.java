/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioalbums;

/**
 *
 * @author marcferrerfernandez
 */
public class album {
    private int num;
    private int any;
    private String titol;
    private String artista;
    private String tipus;
    private float estrelles;
    private int edicions;
    private int votos;
    
    public album(){
        
    }

    public album(int posicio, int any, String nomAlbum, String nomArtista, String tipus, float estrelles, int edicions) {
        this.num = posicio;
        this.any = any;
        this.titol = nomAlbum;
        this.artista = nomArtista;
        this.tipus = tipus;
        this.estrelles = estrelles;
        this.edicions = edicions;
    }
    
    public album (int posicio, int any, String titol, String artista, int votos){
        this.num = posicio;
        this.any = any;
        this.titol = titol;
        this.artista = artista;
        this.votos = votos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public float getEstrelles() {
        return estrelles;
    }

    public void setEstrelles(float estrelles) {
        this.estrelles = estrelles;
    }

    public int getEdicions() {
        return edicions;
    }

    public void setEdicions(int edicions) {
        this.edicions = edicions;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
   
    public String toString1() {
        return "album{" + "num=" + num + ", any=" + any + ", titol=" + titol + ", artista=" + artista + ", tipus=" + tipus + ", estrelles=" + estrelles + ", edicions=" + edicions + '}';
    }
    
    public String toString2(){
        return "#" + num + " vots: " + votos + " " + titol + "Artista: " + artista + " any: " + any;
    }
    
}
