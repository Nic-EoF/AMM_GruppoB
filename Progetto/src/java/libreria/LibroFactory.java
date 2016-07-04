/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class LibroFactory {

    private static LibroFactory singleton;
    ArrayList<Libro> listaLibro;

    public static LibroFactory getInstance() {
        if (singleton == null) {
            singleton = new LibroFactory();
        }
        return singleton;
    }

    public LibroFactory() {
        listaLibro = new ArrayList<>();

        Libro libro1 = new Libro();
        libro1.setNome("Storia Medievale");
        libro1.setPrezzo(15);
        libro1.setQuantità(3);
        libro1.setImmagine("Immagini/helmet.gif");

        Libro libro2 = new Libro();
        libro2.setNome("Preistoria");
        libro2.setPrezzo(10);
        libro2.setQuantità(20);
        libro2.setImmagine("Immagini/mammut.jpg");
        Libro libro3 = new Libro();
        libro3.setNome("Storia Romana");
        libro3.setPrezzo(13);
        libro3.setQuantità(17);
        libro3.setImmagine("Immagini/rome.png");
        Libro libro4 = new Libro();
        libro4.setNome("Storia Cinese");
        libro4.setPrezzo(30);
        libro4.setQuantità(11);
        libro4.setImmagine("Immagini/sun_tzu.jpg");
        Libro libro5 = new Libro();
        libro5.setNome("Storia Moderna");
        libro5.setPrezzo(50);
        libro5.setQuantità(1);
        libro5.setImmagine("Immagini/t90.jpg");
        libro1.setN(1);
        libro2.setN(2);
        libro3.setN(3);
        libro4.setN(4);
        libro5.setN(5);
        listaLibro.add(libro1);
        listaLibro.add(libro2);
        listaLibro.add(libro3);
        listaLibro.add(libro4);
        listaLibro.add(libro5);
    }

    public ArrayList<Libro> getListaLibro() {
        return listaLibro;
    }

}
