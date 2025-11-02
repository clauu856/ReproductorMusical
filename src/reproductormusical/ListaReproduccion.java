/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusical;

/**
 *
 * @author CLAUDIA PC
 */
public class ListaReproduccion {

    private Artista artista;
    private int cantCanciones;

    public ListaReproduccion(Artista artista, int cantCanciones) {
        this.artista = artista;
        this.cantCanciones = cantCanciones;
    }

    public Artista getArtista() {
        return artista;
    }

    public int getCantCanciones() {
        return cantCanciones;
    }

    @Override
    public String toString() {
        return "ListaReproduccion{"
            + "artista=" + artista
            + '}';
    }

}
