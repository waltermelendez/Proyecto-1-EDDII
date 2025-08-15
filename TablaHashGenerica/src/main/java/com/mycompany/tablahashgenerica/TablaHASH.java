/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tablahashgenerica;

/**
 *
 * @author walte
 */
public class TablaHASH {

    private long[] tabla;
    private int largo;
    private int porcentaje;
    

    public TablaHASH(int largo) {
        this.largo = largo;
        this.tabla = new long[largo];
        this.porcentaje = largo;
        
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = 0;
        }
    }

    public void Add(long hash) {
        boolean add = false;
        int posicion = (int) (hash % this.largo);
        if (tabla[posicion] == 0) {
            tabla[posicion] = hash;
            add = true;
            porcentaje--;
        } else if (tabla[posicion] == hash) {
            int j = 1;
            for (int i = posicion + (j * j); i < largo; i++) {
                if (tabla[i] == 0) {
                    tabla[posicion + (i * i)] = hash;
                    add = true;
                    porcentaje--;
                    
                    break;

                }
                j++;
            }
            if (!add) {
                for (int i = 0; i < largo; i++) {
                    if (tabla[i] == 0) {
                        tabla[i] = hash;
                        add = true;
                        porcentaje--;
                        break;
                    }
                }
            }
        }

        if (!add || porcentaje < (largo / 2)) {
            long[] auxiliar = new long[largo * 2];
            auxiliar = resize(this.largo, tabla);
            tabla = new long[this.largo * 2];
            this.tabla = auxiliar;
        }
    }

    public long[] resize(int largo, long[] tabla) {
        int nuevoL = this.largo * 2;
        long[] nuevaT = new long[nuevoL];
        for (int i = 0; i < tabla.length; i++) {
            nuevaT[i] = tabla[i];
        }
        this.largo = nuevoL;
        return nuevaT;
    }

    public int size() {
        return this.largo;
    }

    public void print() {
        for (int i = 0; i < largo; i++) {
            System.out.println(tabla[i]);
        }
    }
    public void delete(long hash){}
    
    public void Search(long hash){}
    
    
}
