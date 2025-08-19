/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author walte
 * @param <T>
 */
public class BPlusTree<T extends Comparable<T> & number> {

    private BPlusTreeNode<T> raiz;
    private int d;

    public BPlusTree(int orden) {
        if (orden < 1) {
            throw new IllegalArgumentException("El orden debe ser al menos 1.");
        }
        this.d = orden;
        this.raiz = new BPlusTreeNode<>(true);
    }

    //Inserción 
    public void insertar(T clave) {
        SplitResult<T> resultado = insertarRecursivo(raiz, clave);

        if (resultado != null) {
            BPlusTreeNode<T> nuevaRaiz = new BPlusTreeNode<>(false);
            nuevaRaiz.claves.add(resultado.claveMediana);
            nuevaRaiz.hijos.add(resultado.izquierdo);
            nuevaRaiz.hijos.add(resultado.derecho);
            raiz = nuevaRaiz;
        }
    }

    //Inserción recursiva
    private SplitResult<T> insertarRecursivo(BPlusTreeNode<T> nodo, T clave) {
        //se crearon dos funciones para poder realizar la inserccion.
        //La razon es para no tener un codigo demasiado complejo
        if (nodo.esHoja) {
            insertarOrdenado(nodo.claves, clave);
            if (nodo.claves.size() > 2 * d) {
                return dividirHoja(nodo);
            }
            return null;
        }

        int i = posicionParaClave(nodo.claves, clave);
        SplitResult<T> split = insertarRecursivo(nodo.hijos.get(i), clave);

        if (split != null) {
            nodo.claves.add(i, split.claveMediana);
            nodo.hijos.set(i, split.izquierdo);
            nodo.hijos.add(i + 1, split.derecho);

            if (nodo.claves.size() > 2 * d) {
                return dividirInterno(nodo);
            }
        }

        return null;
    }

    // Metodo para ser utilizado para invocar a la funcion de posicionparaclave y agregar a la lista
    // con la clave a usar
    private void insertarOrdenado(List<T> lista, T clave) {
        int i = posicionParaClave(lista, clave);
        lista.add(i, clave);
    }

    //Se agrego este metodo para buscar el lugar en donde se debe agregar el nuevo numero
    private int posicionParaClave(List<T> lista, T clave) {
        int i = 0;
        //Se debe usar compareTo para comparar clases genericas
        while (i < lista.size() && clave.compareTo(lista.get(i)) > 0) {
            i++;
        }
        return i;
    }

    //División de nodos
    private SplitResult<T> dividirHoja(BPlusTreeNode<T> hoja) {
        int mid = d;
        T clavePromovida = hoja.claves.get(mid);

        BPlusTreeNode<T> izquierda = new BPlusTreeNode<>(true);
        BPlusTreeNode<T> derecha = new BPlusTreeNode<>(true);

        //Primero se agregan todas las nodos a una pagina, despues 
        /*Despues se se pide una sub lista o sug pagina para poder
         * hacer la division
         */
        izquierda.claves.addAll(hoja.claves.subList(0, mid));
        derecha.claves.addAll(hoja.claves.subList(mid, hoja.claves.size()));

        // Enlace de hojas para recorrido ordenado
        izquierda.siguienteHoja = derecha;
        derecha.anteriorHoja = izquierda;

        derecha.siguienteHoja = hoja.siguienteHoja;
        if (hoja.siguienteHoja != null) {
            hoja.siguienteHoja.anteriorHoja = derecha;
        }

        izquierda.anteriorHoja = hoja.anteriorHoja;
        if (hoja.anteriorHoja != null) {
            hoja.anteriorHoja.siguienteHoja = izquierda;
        }

        return new SplitResult<>(clavePromovida, izquierda, derecha);
    }

    //Metodo para verificar y balancear el arbol cuando se agrega un dato.
    private SplitResult<T> dividirInterno(BPlusTreeNode<T> nodo) {
        int mid = d;
        T clavePromovida = nodo.claves.get(mid);

        BPlusTreeNode<T> izquierda = new BPlusTreeNode<>(false);
        BPlusTreeNode<T> derecha = new BPlusTreeNode<>(false);

        izquierda.claves.addAll(nodo.claves.subList(0, mid));
        derecha.claves.addAll(nodo.claves.subList(mid + 1, nodo.claves.size()));

        izquierda.hijos.addAll(nodo.hijos.subList(0, mid + 1));
        derecha.hijos.addAll(nodo.hijos.subList(mid + 1, nodo.hijos.size()));

        return new SplitResult<>(clavePromovida, izquierda, derecha);
    }

    //Para recorrer en el arbol y 
    //poder imprimirlo simplementes se tiene que usar los nodos enlazados
    //Esto quiere decir que primero se escoje el nodo a mas de la izquierda
    //y luego se imprime como una lista normal
    public void imprimirEnOrden() {
        System.out.println("Recorrido en orden:");

        BPlusTreeNode<T> hoja = raiz;
        while (hoja != null && !hoja.esHoja) {
            hoja = hoja.hijos.get(0);
        }

        while (hoja != null) {
            for (T clave : hoja.claves) {
                System.out.println(clave.toString());
                System.out.println("");
            }
            hoja = hoja.siguienteHoja;
        }

        System.out.println();
    }

    public T Search(int ID) {
        BPlusTreeNode<T> nodo = raiz;

        while (!nodo.esHoja) {
            int i = 0;
            while (i < nodo.claves.size() && ID >= nodo.claves.get(i).getNumber()) {
                i++;
            }
            nodo=nodo.hijos.get(i);
        }
        for (T Nodo : nodo.claves) {
            if (Nodo.getNumber()==ID) {
                return Nodo;
            }
        }
        return null;
    }

    public void ImportarArbol() {
    }

    public void ExportarArbol() {
    }
}
