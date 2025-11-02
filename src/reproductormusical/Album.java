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
public class Album extends Nivel{
    private int annoLanzamiento;
    private String genero;
    private int cantCanciones;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, int annoLanzamiento, String genero, int cantCanciones) {
        super(nombre);
        this.annoLanzamiento = annoLanzamiento;
        this.genero = genero;
        this.cantCanciones = cantCanciones;
        this.canciones = new ArrayList<>();
    }

    public int getAnnoLanzamiento() {
        return annoLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public int getCantCanciones() {
        return cantCanciones;
    }

    public void setCantCanciones(int cantCanciones) {
        this.cantCanciones = cantCanciones;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void agregarCancion(Cancion c){
        canciones.add(c);
    }

//    @Override
//    public String toString() {
//        return "Album{" + "Nombre: " + getNombre() +
//                "annoLanzamiento=" + annoLanzamiento +
//                ", genero='" + genero + '\'' +
//                ", cantCanciones=" + cantCanciones +
//                ", canciones=" + canciones +
//                '}';
//    }
    
    
}
