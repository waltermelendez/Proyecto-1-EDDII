/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.monticulo;

import java.util.Arrays;

/**
 *
 * @author walter
 */
public class Monticulo {

    // Variables de la clase Monticulo
    private int[] monticulo;
    private int numElementos;
    private int maxElementos;
    // Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro
    // el numero de elementos y el numero maximo

    public Monticulo(int num, int max) {
        monticulo = new int[max];
        numElementos = num;
        maxElementos = max;
    }

    // Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro un vector
    public Monticulo(int[] vector, int max) {
        monticulo = new int[max];
        numElementos = vector.length - 1;
        maxElementos = max;
        monticulo = Arrays.copyOf(vector, numElementos + 1);
        for (int i = 2; i < monticulo.length; i++) {
            this.flotar(i);
        }
    }

    public boolean EmptyHeap() {
        if (numElementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void flotar(int elemento) {

        while (elemento > 1 && monticulo[elemento / 2] < monticulo[elemento]) {
            mSwitch(elemento, elemento / 2); // Metodo que intercambiar elementos de un vector
            elemento = elemento / 2;
        }
    }

    public void hundir(int elemento) {
        int hijoi;
        int hijod;
        int padre;

        do {
            hijoi = 2 * elemento;
            hijod = (2 * elemento) + 1;
            padre = elemento;

            if (hijod <= this.numElementos && monticulo[hijod] > monticulo[elemento]) {
                elemento = hijod;
            }

            if (hijoi <= this.numElementos && monticulo[hijoi] > monticulo[elemento]) {
                elemento = hijoi;
            }

            mSwitch(padre, elemento);
            elemento = elemento / 2;
        } while (padre == elemento);
    }

    public void insert(int elemento) {
        if (this.numElementos == this.maxElementos) {
            System.out.println("El monticulo esta lleno y no podemos añadir nuevos elementos");
        } else {
            this.numElementos++;
            monticulo[this.numElementos] = elemento;
            flotar(this.numElementos);
        }
    }

    public int first() {
        if (this.EmptyHeap()) {
            System.out.println("No hay elementos en el monticulo.");
            return Integer.MAX_VALUE;
        } else {
            return monticulo[1];
        }
    }

    public int peek() {

        int element;

        if (this.numElementos != 0) {
            element = monticulo[1];
            monticulo[1] = monticulo[this.numElementos];
            this.numElementos--;
            this.hundir(1);
            return element;
        }

        return Integer.MAX_VALUE;
    }

    private void mSwitch(int element1, int element2) {
        int auxiliar;

        auxiliar = monticulo[element1];
        monticulo[element1] = monticulo[element2];
        monticulo[element2] = auxiliar;

    }

}
