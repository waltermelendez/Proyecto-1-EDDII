/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.finnal;

import java.util.ArrayList;

/**
 *
 * @author walter
 * @param <T>
 */
public class Monticulo <T extends Comparable<T>> {

    // Variables de la clase Monticulo
    private final ArrayList<T> monticulo;
    private int numElementos;
    
    // Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro
    // el numero de elementos y el numero maximo

   

    // Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro un vector
    public Monticulo(ArrayList<T> vector) {
        monticulo = new ArrayList<>();
        //monticulo.add(valor);
        for (int i = 0; i < vector.size(); i++) {
            monticulo.add(vector.get(i));
            
        }
        for (int i = 2; i < vector.size(); i++) {
            flotar(i);
        }
        numElementos=vector.size();
    }

    public boolean EmptyHeap() {
        return monticulo.isEmpty();
    }

    private  void flotar(int elemento) {

        while (elemento > 1 && monticulo.get(elemento/2).compareTo(monticulo.get(elemento))<0) {
            mSwitch(elemento, elemento / 2); // Metodo que intercambiar elementos de un vector
            elemento = elemento / 2;
        }
    }

    private  void hundir(int elemento) {
        int hijoi;
        int hijod;
        int padre;

        do {
            hijoi = 2 * elemento;
            hijod = (2 * elemento) + 1;
            padre = elemento;

            if (hijod <= this.numElementos && monticulo.get(hijod).compareTo(monticulo.get(elemento))>0) {
                elemento = hijod;
            }

            if (hijoi <= this.numElementos && monticulo.get(hijoi).compareTo(monticulo.get(elemento))>0) {
                elemento = hijoi;
            }

            mSwitch(padre, elemento);
            elemento = elemento / 2;
        } while (padre == elemento);
    }

    public void insert(T elemento) {
        monticulo.add(elemento);
        numElementos++;
        flotar(numElementos);
    }

    public T first() {
        if (this.EmptyHeap()) {
            System.out.println("El monticulo esta vacio");
            return null;
        } else {
            return monticulo.get(1);
        }
    }

    public T peek() {

        T element;

        if (this.numElementos != 0) {
            element = monticulo.get(1);
            monticulo.set(1,monticulo.get(numElementos));
            this.numElementos--;
            this.hundir(1);
            return element;
        }

        return null;
    }

    private void mSwitch(int element1, int element2) {
        T auxiliar = monticulo.get(element1);
        monticulo.set(element1, monticulo.get(element2));
        monticulo.set(element2, auxiliar);

       

    }
    
    public void Imprimir(){
        System.out.println("Monticulo");
        for (int i = 0; i < monticulo.size(); i++) {
            System.out.println(monticulo.get(i)+",");
        }
        System.out.println();
    }

}
