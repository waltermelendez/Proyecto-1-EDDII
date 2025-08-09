/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolesbplus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author walte
 * @param <T>
 */
public class BPlusTree<T extends Comparable<T>> {

    private BPlusTreeNode<T> raiz;
    private final int d;

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
    
   public void saveToFile(String filename) {
    Map<BPlusTreeNode<T>, Integer> nodeIds = new HashMap<>();
    List<JSONObject> nodosJson = new ArrayList<>();
    int[] nextId = {0};

    Queue<BPlusTreeNode<T>> queue = new LinkedList<>();
    queue.add(raiz);
    nodeIds.put(raiz, nextId[0]++);

    while (!queue.isEmpty()) {
        BPlusTreeNode<T> actual = queue.poll();
        int id = nodeIds.get(actual);

        JSONObject nodoObj = new JSONObject();
        nodoObj.put("id", id);
        nodoObj.put("esHoja", actual.esHoja);

        JSONArray clavesJson = new JSONArray();
        for (T clave : actual.claves) {
            if (clave instanceof Paciente) {
                clavesJson.put(((Paciente)clave).ToJson());
            } else {
                clavesJson.put(clave.toString());
            }
        }
        nodoObj.put("claves", clavesJson);

        if (actual.esHoja) {
            if (actual.siguienteHoja != null) {
                nodeIds.putIfAbsent(actual.siguienteHoja, nextId[0]);
                nodoObj.put("siguienteHoja", nodeIds.get(actual.siguienteHoja));
                if (!nodeIds.containsKey(actual.siguienteHoja)) {
                    queue.add(actual.siguienteHoja);
                    nextId[0]++;
                }
            }
            if (actual.anteriorHoja != null) {
                nodeIds.putIfAbsent(actual.anteriorHoja, nextId[0]);
                nodoObj.put("anteriorHoja", nodeIds.get(actual.anteriorHoja));
                if (!nodeIds.containsKey(actual.anteriorHoja)) {
                    queue.add(actual.anteriorHoja);
                    nextId[0]++;
                }
            }
        } else {
            JSONArray hijosIds = new JSONArray();
            for (BPlusTreeNode<T> hijo : actual.hijos) {
                nodeIds.putIfAbsent(hijo, nextId[0]);
                hijosIds.put(nodeIds.get(hijo));
                if (!nodeIds.containsKey(hijo)) {
                    queue.add(hijo);
                    nextId[0]++;
                }
            }
            nodoObj.put("hijos", hijosIds);
        }

        nodosJson.add(nodoObj);
    }

    JSONObject raizJson = new JSONObject();
    raizJson.put("raiz", nodeIds.get(raiz));
    raizJson.put("orden", d);
    raizJson.put("tipoClave", "Integer"); // sugerencia para recuperar el tipo
    raizJson.put("nodos", nodosJson);

    try (FileWriter file = new FileWriter(filename)) {
        file.write(raizJson.toString(2));
    } catch (IOException e) {
        System.err.println("Error al guardar: " + e.getMessage());
    }
}
    
   public  BPlusTree<T> loadFromFile(String filename) throws IOException {
    
        try {
            //Se  obtiene el archivo
        String content = Files.readString(Paths.get(filename));
        JSONObject json = new JSONObject(content);
        int d = json.getInt("orden"); //se obtine el orden
        int idRaiz = json.getInt("raiz"); // se obtine la raiz

        //Creacion de nodos
        JSONArray nodosArray = json.getJSONArray("nodos");
        Map<Integer, BPlusTreeNode> mapaNodos = new HashMap<>();

        //Asginacion de valores a los nodos
        for (int i = 0; i < nodosArray.length(); i++) {
            JSONObject obj = nodosArray.getJSONObject(i);
            boolean esHoja = obj.getBoolean("esHoja");

            BPlusTreeNode nodo = new BPlusTreeNode(esHoja);
            nodo.claves = new ArrayList<>();
            JSONArray clavesJson = obj.getJSONArray("claves");
            for (int k = 0; k < clavesJson.length(); k++) {
               
                
               JSONObject nuevo = clavesJson.getJSONObject(k);
               nodo.claves.add((T) Paciente.loadJson(nuevo));
            }

            mapaNodos.put(obj.getInt("id"), nodo);
        }

        // Agregar los enlaces de los nodos
        for (int i = 0; i < nodosArray.length(); i++) {
            JSONObject obj = nodosArray.getJSONObject(i);
            int id = obj.getInt("id");
            BPlusTreeNode nodo = mapaNodos.get(id);

            
            if (nodo.esHoja) {
                //
                if (obj.has("siguienteHoja")) {
                    nodo.siguienteHoja = mapaNodos.get(obj.getInt("siguienteHoja"));
                }
                if (obj.has("anteriorHoja")) {
                    nodo.anteriorHoja = mapaNodos.get(obj.getInt("anteriorHoja"));
                }
            } else {
                //si el nodo es intermedio
                JSONArray hijosJson = obj.getJSONArray("hijos");
                for (int h = 0; h < hijosJson.length(); h++) {
                    nodo.hijos.add(mapaNodos.get(hijosJson.getInt(h)));
                }
            }
        }

        //Creacion y de volver el arbol
        BPlusTree arbol = new BPlusTree(d);
        arbol.raiz = mapaNodos.get(idRaiz);
        return arbol;

    } catch (JSONException e) {
        System.out.println("Error al cargar el árbol B+: " + e.getMessage());
        return null;
    }
}
}




