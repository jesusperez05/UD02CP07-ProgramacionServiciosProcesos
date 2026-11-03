package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() throws InterruptedException {
        List<Integer> lista = new ArrayList<>();

        lista.add(8);
        lista.add(93);
        lista.add(1);
        lista.add(4);
        lista.add(20);

        System.out.println("Antes:   " + lista);

        Nodo hiloRaiz = new Nodo(lista);
        hiloRaiz.start();
        hiloRaiz.join();

        System.out.println("Después: " + lista);
    }
}