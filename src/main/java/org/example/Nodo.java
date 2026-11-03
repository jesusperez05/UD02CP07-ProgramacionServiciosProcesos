package org.example;

import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread {

    private List<Integer> lista;

    public Nodo(List<Integer> lista) {
        this.lista = lista;
    }

    private void añade(List<Integer> l, int desde, int hasta) {
        l.addAll(lista.subList(desde, hasta));
    }

    private void mezcla(List<Integer> l1, List<Integer> l2) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                lista.set(k, l1.get(i));
                i++;
            } else {
                lista.set(k, l2.get(j));
                j++;
            }
            k++;
        }

        while (i < l1.size()) {
            lista.set(k, l1.get(i));
            i++;
            k++;
        }

        while (j < l2.size()) {
            lista.set(k, l2.get(j));
            j++;
            k++;
        }
    }

    @Override
    public void run() {
        if (lista.size() > 1) {
            int mitad = lista.size() / 2;

            List<Integer> izquierda = new ArrayList<>();
            List<Integer> derecha = new ArrayList<>();

            añade(izquierda, 0, mitad);
            añade(derecha, mitad, lista.size());

            Nodo hiloIzquierda = new Nodo(izquierda);
            Nodo hiloDerecha = new Nodo(derecha);

            hiloIzquierda.start();
            hiloDerecha.start();

            try {
                hiloIzquierda.join();
                hiloDerecha.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            mezcla(izquierda, derecha);
        }
    }
}