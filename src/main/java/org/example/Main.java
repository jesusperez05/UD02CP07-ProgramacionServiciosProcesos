package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static void main() throws InterruptedException {
        Random random = new Random();

        int cantidad = 5 + random.nextInt(96);
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            lista.add(1 + random.nextInt(100));
        }

        System.out.println("Antes:   " + lista);

        Nodo hiloRaiz = new Nodo(lista);
        hiloRaiz.start();
        hiloRaiz.join();

        System.out.println("Después: " + lista);
    }
}