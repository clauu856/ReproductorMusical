/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusical;

/**
 *
 * @author CLAUDIA PC
 */
public class Cancion extends Nivel {
    private String duracion;
    private int numPista;
    private int cantReproducciones;

    public Cancion(String nombre, String duracion, int numPista, int cantReproducciones) {
        super(nombre);
        this.duracion = duracion;
        this.numPista = numPista;
        this.cantReproducciones = cantReproducciones;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getCantReproducciones() {
        return cantReproducciones;
    }

    @Override
    public String toString() {
        return "Cancion{" + "Nombre: " + getNombre() + '}';
    }
    
}
