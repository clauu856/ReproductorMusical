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
public class Sello extends Nivel {
    private String paisOrigen;
    private int annoFundacion;
    private ArrayList<Artista> artistas;

    public Sello(String nombre,  String paisOrigen, int annoFundacion) {
        super(nombre);
        this.annoFundacion = annoFundacion;
        this.paisOrigen = paisOrigen;
        this.artistas = new ArrayList<>();
    }

    public void agregarArtista(Artista a){
        artistas.add(a);
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }
    
    
}
