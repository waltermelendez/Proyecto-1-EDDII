/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolesbplus;

/**
 *
 * @author walte
 * @param <T>
 */
public class SplitResult  <T extends Comparable<T>>{

    T claveMediana;
    BPlusTreeNode <T>izquierdo;
    BPlusTreeNode <T>derecho;

    public SplitResult(T claveMediana, BPlusTreeNode<T> izquierdo, BPlusTreeNode<T> derecho) {
        this.claveMediana = claveMediana;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
}
