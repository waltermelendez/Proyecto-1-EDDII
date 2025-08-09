/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.monticulo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author walter
 */
public class Monticulo {

    // Variables de la clase Monticulo
    private ArrayList<Integer> monticulo;
    private int numElementos;
    
    // Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro
    // el numero de elementos y el numero maximo

   

    // Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro un vector
    public Monticulo(ArrayList<Integer> vector) {
        monticulo = new ArrayList<>();
        monticulo.add(0);
        for (int i = 0; i < vector.size(); i++) {
            monticulo.add(i);
            
        }
        for (int i = 2; i < vector.size(); i++) {
            flotar(i);
        }
        numElementos=vector.size();
    }

    public boolean EmptyHeap() {
        return monticulo.isEmpty();
    }

    public void flotar(int elemento) {

        while (elemento > 1 && monticulo.get(elemento / 2) < monticulo.get(elemento)) {
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

            if (hijod <= this.numElementos && monticulo.get(hijod) > monticulo.get(elemento)) {
                elemento = hijod;
            }

            if (hijoi <= this.numElementos && monticulo.get(hijoi) > monticulo.get(elemento)) {
                elemento = hijoi;
            }

            mSwitch(padre, elemento);
            elemento = elemento / 2;
        } while (padre == elemento);
    }

    public void insert(int elemento) {
        monticulo.add(elemento);
        numElementos++;
        flotar(numElementos);
    }

    public int first() {
        if (this.EmptyHeap()) {
            System.out.println("El monticulo esta vacio");
            return 0;
        } else {
            return monticulo.get(1);
        }
    }

    public int peek() {

        int element;

        if (this.numElementos != 0) {
            element = monticulo.get(1);
            monticulo.set(1,monticulo.get(numElementos));
            this.numElementos--;
            this.hundir(1);
            return element;
        }

        return 0;
    }

    private void mSwitch(int element1, int element2) {
        int auxiliar = monticulo.get(element1);
        monticulo.set(element1, monticulo.get(element2));
        monticulo.set(element2, auxiliar);

       

    }

}
