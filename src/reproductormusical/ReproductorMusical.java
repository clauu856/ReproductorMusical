/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reproductormusical;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author CLAUDIA PC
 */
public class ReproductorMusical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Reproductor
        Reproductor reproductor = new Reproductor();

        // Plataforma
        Plataforma plataforma = new Plataforma("FlowLatino", 2022);

        //Sello
        Sello sello1 = new Sello("UrbanWave Records", "Puerto Rico", 2018);
        Sello sello2 = new Sello("TrapHouse Music", "Puerto Rico", 2020);
        Sello sello8 = new Sello("Eclipse Milano", "Italia", 2022);
        Sello sello9 = new Sello("XO Records", "Canadá", 2011);

        // Artista
        Artista omarCourtz = new Artista("Oussy", "Reggaetón", "Puerto Rico");
        Artista deLaRose = new Artista("De la Rose", "Trap Latino", "Puerto Rico");
        Artista daiV = new Artista("Dai V", "Urbano", "Puerto Rico");
        Artista roa = new Artista("Roa", "Trap", "Puerto Rico");
        Artista lualL = new Artista("Lual L", "Reggaetón", "Puerto Rico");
        Artista damiano = new Artista("Damiano David", "Rock Alternativo", "Italia");
        Artista theWeeknd = new Artista("The Weeknd", "R&B/Pop", "Canadá");

        // Canciones
        // Oussy
        Cancion oussy1 = new Cancion("Amber", "3:12", 1, 1500000);
        Cancion oussy2 = new Cancion("Kyoto", "3:20", 6, 760000);
        Cancion oussy3 = new Cancion("Mas que algo", "3:28", 17, 890000);

        // De la Rose
        Cancion deLaRose1 = new Cancion("ETA RMX", "4:05", 2, 2200000);
        Cancion deLaRose2 = new Cancion("Nubes", "3:45", 3, 980000);

        // Dai V
        Cancion c4 = new Cancion("Toa", "3:30", 4, 870000);
        Cancion c5 = new Cancion("Loco", "2:58", 5, 1200000);

        // Damiano David
        Cancion damianoDavid1 = new Cancion("Sangue e Fiamme", "3:50", 1, 2100000);
        Cancion damianoDavid2 = new Cancion("Milano Notte", "4:10", 2, 1800000);

       // The Weeknd
        Cancion weeknd1 = new Cancion("Starlight", "3:40", 1, 5000000);
        Cancion weekend2 = new Cancion("Echoes in the Dark", "4:00", 2, 4700000);

        // lual l
        Cancion luaL1 = new Cancion("Fuego en la Pista", "3:22", 1, 980000);
        Cancion luaL2 = new Cancion("Noche Sin Fin", "3:35", 2, 870000);

        // roa
        Cancion roa1 = new Cancion("Sombras del Asfalto", "3:40", 1, 890000);
        Cancion roa2 = new Cancion("Código Callejero", "3:18", 2, 970000);

        // Álbumes y asignación de canciones
        // Oussy
        Album albumOmar = new Album("Vibes de Oussy", 2024, "Reggaetón", 3);
        albumOmar.agregarCancion(oussy1);
        albumOmar.agregarCancion(oussy2);
        albumOmar.agregarCancion(oussy3);
        omarCourtz.agregarAlbum(albumOmar);

        // De la Rose
        Album albumDeLaRose = new Album("Trap Rosa", 2023, "Trap Latino", 2);
        albumDeLaRose.agregarCancion(deLaRose1);
        albumDeLaRose.agregarCancion(deLaRose2);
        deLaRose.agregarAlbum(albumDeLaRose);

        // Dai V
        Album albumDaiV = new Album("Los Flavorz", 2025, "Urbano", 2);
        albumDaiV.agregarCancion(c4);
        albumDaiV.agregarCancion(c5);
        daiV.agregarAlbum(albumDaiV);

        // Lual l
        Album albumLualNuevo = new Album("Ritmos del Mañana", 2025, "Reggaetón", 4);
        albumLualNuevo.agregarCancion(luaL1);
        albumLualNuevo.agregarCancion(luaL2);
        lualL.agregarAlbum(albumLualNuevo);

        // Roa
        Album albumRoaNuevo = new Album("Desde el Subsuelo", 2025, "Trap", 3);
        albumRoaNuevo.agregarCancion(roa1);
        albumRoaNuevo.agregarCancion(roa2);
        roa.agregarAlbum(albumRoaNuevo);

        // Damiano David
        Album albumDamiano = new Album("Fiamme", 2024, "Rock Alternativo", 2);
        albumDamiano.agregarCancion(damianoDavid1);
        albumDamiano.agregarCancion(damianoDavid2);
        damiano.agregarAlbum(albumDamiano);

        // The Weeknd
        Album albumWeeknd = new Album("After Dusk", 2025, "R&B/Pop", 2);
        albumWeeknd.agregarCancion(weeknd1);
        albumWeeknd.agregarCancion(weekend2);
        theWeeknd.agregarAlbum(albumWeeknd);

        // Asignación de artistas a sellos
        sello1.agregarArtista(omarCourtz);
        sello1.agregarArtista(deLaRose);

        sello2.agregarArtista(daiV);
        sello2.agregarArtista(roa);
        sello2.agregarArtista(lualL);

        sello8.agregarArtista(damiano);
        sello9.agregarArtista(theWeeknd);

        // Agregar sellos a la plataforma
        plataforma.agregarSello(sello1);
        plataforma.agregarSello(sello2);
        plataforma.agregarSello(sello8);
        plataforma.agregarSello(sello9);

        // creacion album
        reproductor.crearArbolReproductor(plataforma);

        //incico b
        System.out.println();
        System.out.println("Cancion mas reproducida");
        Cancion masReproduccida = reproductor.cancionMasReproducida();
        System.out.println("La cancion mas reproduccida es: " + masReproduccida);

        //inciso c
        System.out.println();
        System.out.println("Trasnferir artista a otro sello");
        reproductor.transferirArtistaSelloAOtro("Oussy", "TrapHouse Music");

        //incsiso d
        System.out.println();
        System.out.println("Actualizar album de canciones agregando nuevas canciones");
        ArrayList<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion("Versos de Medianoche", "3:28", 17, 890000));
        canciones.add(new Cancion("Musa en Llamas", "3:15", 18, 1020000));
        canciones.add(new Cancion("Notas del Silencio", "3:40", 19, 760000));
        canciones.add(new Cancion("Ritmo de Cristal", "2:58", 20, 980000));
        canciones.add(new Cancion("Entre Sombras", "3:22", 21, 870000));
        reproductor.actualizarAlbumArtista("Oussy", "Vibes de Oussy", canciones);

        //inciso e
        System.out.println();
        System.out.println("obtener una lista de reproducción dado el nombre de diferentes artistas " +
                "y la cantidad de canciones de cada artista a incluir");
        ArrayList<ListaReproduccion> list = new ArrayList<>();
        list.add(new ListaReproduccion(roa, 1));
        list.add(new ListaReproduccion(deLaRose, 2));
        list.add(new ListaReproduccion(omarCourtz, 2));
        list.add(new ListaReproduccion(lualL, 1));

        Queue<Cancion> colaReproduccion = reproductor.listaReproduccions(list);
        System.out.println("La cola queda: " + colaReproduccion);
    
    }
    
}
