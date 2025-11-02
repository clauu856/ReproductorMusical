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
public class Plataforma extends Nivel{
    private int annoCreacion;
    private ArrayList<Sello> sellos;

    public Plataforma(String nombre, int annoCreacion){
        super(nombre);
        this.annoCreacion = annoCreacion;
        this.sellos = new ArrayList<>();
    }

    public void agregarSello(Sello s){
        sellos.add(s);
    }

    public ArrayList<Sello> getSellos() {
        return sellos;
    }
    
    
}
