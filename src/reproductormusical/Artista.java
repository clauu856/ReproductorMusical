/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusical;

import java.util.ArrayList;

/**
 *
 * @author CLAUDIA PC
 */
public class Artista extends Nivel{
    private String generoMusicalPrincipal;
    private String nacionalidad;
    private ArrayList<Album> albumes;

    public Artista(String nombre, String generoMusicalPrincipal, String nacionalidad) {
        super(nombre);
        this.generoMusicalPrincipal = generoMusicalPrincipal;
        this.nacionalidad = nacionalidad;
        this.albumes = new ArrayList<>();
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void agregarAlbum(Album a){
        albumes.add(a);
    }

    @Override
    public String toString() {
        return "Artista{" + "Nombre: " + getNombre() +
                "albumes=" + albumes +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", generoMusicalPrincipal='" + generoMusicalPrincipal + '\'' +
                '}';
    }
    
    
}
