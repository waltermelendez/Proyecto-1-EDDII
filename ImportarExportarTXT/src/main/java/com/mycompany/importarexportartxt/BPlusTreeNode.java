/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author walte
 * @param <T>
 */
//Se agregaron nodos para poder convertir un arbol B a uno B+
public class BPlusTreeNode <T extends Comparable<T>>{

    List<T> claves;
    List<BPlusTreeNode<T>> hijos;
    List<Paciente> pacientes;
    boolean esHoja;

    // Punteros de hoja (B+ Tree)
    BPlusTreeNode<T> siguienteHoja;
    BPlusTreeNode <T>anteriorHoja;

    public BPlusTreeNode(boolean esHoja) {
        this.claves = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.esHoja = esHoja;
        this.siguienteHoja = null;
        this.anteriorHoja = null;
    }
    
  
    
}
