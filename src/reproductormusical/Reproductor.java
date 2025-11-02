/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusical;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author CLAUDIA PC
 */
public class Reproductor {
    private GeneralTree<Nivel> reproductor;

    public Reproductor() {
        this.reproductor = new GeneralTree<>();
    }

    // Inciso b
    // determinar la canción más reproducida de toda la plataforma.
    public Cancion cancionMasReproducida() {
        Cancion cancion = null;
        InBreadthIterator<Nivel> itr = reproductor.inBreadthIterator();
        int cantReproducciones = 0;
        while (itr.hasNext()) {
            BinaryTreeNode<Nivel> nodo = itr.nextNode();
            Nivel actual = nodo.getInfo();
            if (actual instanceof Cancion) {
                Cancion c = (Cancion) actual;
                int reproducciones = c.getCantReproducciones();
                if (cantReproducciones < reproducciones) {
                    cancion = c;
                    cantReproducciones = reproducciones;
                }
            }
        }
        return cancion;
    }

    // inciso c
    // transferir un artista de un sello discográfico a otro.
    public void transferirArtistaSelloAOtro(String nombreArtista, String nombreSello) {

        BinaryTreeNode<Nivel> nodoArtista = buscarArtista(nombreArtista);
        BinaryTreeNode<Nivel> nodoSelloN = buscarSello(nombreSello);

        GeneralTree<Nivel> aux = new GeneralTree<>();

        if (nodoArtista != null) {
            Artista artista = (Artista) nodoArtista.getInfo();
            aux = crearSubArbol(artista);
            this.reproductor.deleteNode(nodoArtista);
            System.out.println();
            if (nodoSelloN != null) {
                crearHijoArbolOriginal(nodoSelloN, aux);
                System.out.println();
                mostrarArbolReproductor();
            } else {
                System.out.println("El sello no existe");
            }
        } else {
            System.out.println("El artista no existe");
        }
    }

    //Inciso d
    // Actualizar álbum de canciones agregando nuevas canciones
    public void actualizarAlbumArtista(String nombreArtista, String nombreAlbum, ArrayList<Cancion> listaCanciones) {

        BinaryTreeNode<Nivel> nodoArtista = buscarArtista(nombreArtista);
        BinaryTreeNode<Nivel> nodoAlbum = buscarAlbum(nombreAlbum);
        boolean enc = false;

        if (nodoArtista != null) {
            Artista a = (Artista) nodoArtista.getInfo();
            if (nodoAlbum != null) {
                Album album = (Album) nodoAlbum.getInfo();
                for (int i = 0; i < a.getAlbumes().size() && !enc; i++) {
                    if (a.getAlbumes().get(i).equals(album)) {
                        enc = true;
                    }
                }

                if (enc == true) {
                    int cantC = album.getCantCanciones();
                    int totalC = cantC + listaCanciones.size();
                    album.setCantCanciones(totalC);
                    if (!listaCanciones.isEmpty()) {
                        for (int i = 0; i < listaCanciones.size(); i++) {
                            Cancion c = listaCanciones.get(i);
                            BinaryTreeNode<Nivel> nodoCanciones = new BinaryTreeNode<>(c);
                            reproductor.insertNode(nodoCanciones, nodoAlbum);
                            album.agregarCancion(c);
                        }
                        System.out.println();
                        mostrarArbolReproductor();
                    } else {
                        System.out.println("La lista de musica esta vacia");
                    }
                } else {
                    System.out.println("El album " + nombreAlbum + " no pertenece a " + nombreArtista);
                }
            } else {
                System.out.println("El album " + nombreAlbum + " no existe");
            }
        } else {
            System.out.println("El artista " + nombreArtista + " no existe");
        }
    }

    //Inciso e
    //obtener una lista de reproducción dado el nombre de diferentes artistas y
    // la cantidad de canciones de cada artista a incluir
    public Queue<Cancion> listaReproduccions(ArrayList<ListaReproduccion> list) {
        Queue<Cancion> listaReproduccionQueue = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            int cont = 0;
            boolean fin = false;
            ListaReproduccion lR = list.get(i);
            InBreadthIterator<Nivel> itr = reproductor.inBreadthIterator();
            while (itr.hasNext() && !fin) {
                BinaryTreeNode<Nivel> node = itr.nextNode();
                Nivel actual = node.getInfo();
                if (actual instanceof Artista) {
                    Artista a = (Artista) actual;
                    if (lR.getArtista().getNombre().contains(a.getNombre())) {
                        for (int j = 0; j < a.getAlbumes().size() && !fin; j++) {
                            Album album = a.getAlbumes().get(j);
                            for (int k = 0; k < album.getCanciones().size() && !fin; k++) {
                                Cancion cancion = album.getCanciones().get(k);
                                cont++;
                                if (cont <= lR.getCantCanciones()) {
                                    listaReproduccionQueue.offer(cancion);
                                } else {
                                    fin = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return listaReproduccionQueue;
    }

    // MÉTODOS AUXILIARES
    // crear árbol original
    public void crearArbolReproductor(Plataforma plataforma) {
        BinaryTreeNode<Nivel> nodoPlataforma = new BinaryTreeNode<>(plataforma);
        reproductor.setRoot(nodoPlataforma);
        for (int i = 0; i < plataforma.getSellos().size(); i++) {
            Sello sello = plataforma.getSellos().get(i);
            BinaryTreeNode<Nivel> nodoSello = new BinaryTreeNode<>(sello);
            reproductor.insertNode(nodoSello, nodoPlataforma);
            for (int j = 0; j < sello.getArtistas().size(); j++) {
                Artista artista = sello.getArtistas().get(j);
                BinaryTreeNode<Nivel> nodoArtista = new BinaryTreeNode<>(artista);
                reproductor.insertNode(nodoArtista, nodoSello);
                for (int k = 0; k < artista.getAlbumes().size(); k++) {
                    Album album = artista.getAlbumes().get(k);
                    BinaryTreeNode<Nivel> nodoAlbum = new BinaryTreeNode<>(album);
                    reproductor.insertNode(nodoAlbum, nodoArtista);
                    for (int l = 0; l < album.getCanciones().size(); l++) {
                        Cancion cancion = album.getCanciones().get(l);
                        BinaryTreeNode<Nivel> nodoCancion = new BinaryTreeNode<>(cancion);
                        reproductor.insertNode(nodoCancion, nodoAlbum);
                    }
                }
            }
        }
        mostrarArbolReproductor();
    }

    // crear hijos Árbol original
    private void crearHijoArbolOriginal(BinaryTreeNode<Nivel> nodoSello, GeneralTree<Nivel> aux) {
        BinaryTreeNode<Nivel> nodoArtista = (BinaryTreeNode) aux.getRoot();
        BinaryTreeNode<Nivel> nodoAlbum = null;

        InBreadthIterator<Nivel> itr = aux.inBreadthIterator();
        while (itr.hasNext()) {
            BinaryTreeNode<Nivel> node = itr.nextNode();
            Nivel actual = node.getInfo();
            if (actual instanceof Artista) {
                Artista artista = (Artista) actual;
                nodoArtista = new BinaryTreeNode<>(artista);
                reproductor.insertNode(nodoArtista, nodoSello);
            }
            if (actual instanceof Album) {
                Album album = (Album) actual;
                nodoAlbum = new BinaryTreeNode<>(album);
                reproductor.insertNode(nodoAlbum, nodoArtista);
            }
            if (actual instanceof Cancion) {
                Cancion cancion = (Cancion) actual;
                BinaryTreeNode<Nivel> nodoCancion = new BinaryTreeNode<>(cancion);
                reproductor.insertNode(nodoCancion, nodoAlbum);
            }
        }
    }

    //Crear un subárbol
    private GeneralTree<Nivel> crearSubArbol(Artista artista) {
        GeneralTree<Nivel> aux = new GeneralTree<>();
        BinaryTreeNode<Nivel> nodoArtistaNuevo = new BinaryTreeNode<>(artista);
        aux.setRoot(nodoArtistaNuevo);

        for (int i = 0; i < artista.getAlbumes().size(); i++) {
            Album album = artista.getAlbumes().get(i);
            BinaryTreeNode<Nivel> nodoAlbum = new BinaryTreeNode<>(album);
            aux.insertNode(nodoAlbum, nodoArtistaNuevo);
            for (int j = 0; j < album.getCanciones().size(); j++) {
                Cancion cancion = album.getCanciones().get(j);
                BinaryTreeNode<Nivel> nodoCancion = new BinaryTreeNode<>(cancion);
                aux.insertNode(nodoCancion, nodoAlbum);
            }
        }
        return aux;
    }

    //buscar artista
    private BinaryTreeNode<Nivel> buscarArtista(String name) {
        BinaryTreeNode<Nivel> artista = null;
        InBreadthIterator<Nivel> itr = reproductor.inBreadthIterator();
        boolean found = false;
        while (itr.hasNext() && !found) {
            BinaryTreeNode<Nivel> nodo = itr.nextNode();
            Nivel actual = nodo.getInfo();
            if (actual instanceof Artista) {
                Artista a = (Artista) actual;
                if (a.getNombre().equals(name)) {
                    artista = nodo;
                    found = true;
                }
            }
        }
        return artista;
    }

    //buscar sello
    private BinaryTreeNode<Nivel> buscarSello(String name) {
        BinaryTreeNode<Nivel> sello = null;
        InBreadthIterator<Nivel> itr = reproductor.inBreadthIterator();
        boolean found = false;
        while (itr.hasNext() && !found) {
            BinaryTreeNode<Nivel> nodo = itr.nextNode();
            Nivel actual = nodo.getInfo();
            if (actual instanceof Sello) {
                Sello a = (Sello) actual;
                if (a.getNombre().equals(name)) {
                    sello = nodo;
                    found = true;
                }
            }
        }
        return sello;
    }

    //buscar album
    private BinaryTreeNode<Nivel> buscarAlbum(String name) {
        BinaryTreeNode<Nivel> album = null;
        InBreadthIterator<Nivel> itr = reproductor.inBreadthIterator();
        boolean found = false;
        while (itr.hasNext() && !found) {
            BinaryTreeNode<Nivel> nodo = itr.nextNode();
            Nivel actual = nodo.getInfo();
            if (actual instanceof Album) {
                Album a = (Album) actual;
                if (a.getNombre().equals(name)) {
                    album = nodo;
                    found = true;
                }
            }
        }
        return album;
    }

    // mostrar árbol
    private void mostrarArbolReproductor() {
        BinaryTreeNode<Nivel> raiz = (BinaryTreeNode<Nivel>) reproductor.getRoot();
        if (raiz == null) {
            System.out.println("El árbol del reproductor está vacío.");

        } else {

            Nivel info = raiz.getInfo();
            if (info instanceof Plataforma plataforma) {
                System.out.println("Plataforma: " + plataforma.getNombre());
                System.out.println();
            }

            BinaryTreeNode<Nivel> nodoSello = raiz.getLeft();
            while (nodoSello != null) {
                Nivel nivelSello = nodoSello.getInfo();
                if (nivelSello instanceof Sello sello) {
                    System.out.println("----> Sello: " + sello.getNombre() + " <----");

                    BinaryTreeNode<Nivel> nodoArtista = nodoSello.getLeft();
                    while (nodoArtista != null) {
                        Nivel nivelArtista = nodoArtista.getInfo();
                        if (nivelArtista instanceof Artista artista) {
                            System.out.println("------> Artista: " + artista.getNombre());

                            BinaryTreeNode<Nivel> nodoAlbum = nodoArtista.getLeft();
                            while (nodoAlbum != null) {
                                Nivel nivelAlbum = nodoAlbum.getInfo();
                                if (nivelAlbum instanceof Album album) {
                                    System.out.println("--------> Álbum: " + album.getNombre());

                                    BinaryTreeNode<Nivel> nodoCancion = nodoAlbum.getLeft();
                                    while (nodoCancion != null) {
                                        Nivel nivelCancion = nodoCancion.getInfo();
                                        if (nivelCancion instanceof Cancion cancion) {
                                            System.out.println("----------> Canción: " + cancion.getNombre());
                                        }
                                        nodoCancion = nodoCancion.getRight();
                                    }
                                }
                                nodoAlbum = nodoAlbum.getRight();
                                System.out.println();
                            }
                        }
                        nodoArtista = nodoArtista.getRight();
                        //System.out.println();
                    }
                }
                nodoSello = nodoSello.getRight();
                System.out.println();
                System.out.println("⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓"
                    + "⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓⁓");
                System.out.println();
            }
        }

    }

    
}
