/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author walte
 * @param <T>
 */
public class Tabla <T extends Table> {

    private T[] tabla;
    private int largo;
    private int porcentaje;
    private final int[] iguales;

    public Tabla(int largo) {
        this.tabla = (T[]) new HashPaciente[largo];
        this.largo = largo;
        this.porcentaje = largo;
        this.iguales = new int[largo];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = null;
        }
        for (int i = 0; i < iguales.length; i++) {
            iguales[i] = -1;
        }
    }

    public void Add(T hash) {
        boolean add = false;
        int posicion = (int) (Tohash(hash) % this.largo);
        //T nuevo = new HashPaciente(hash, Tohash(hash),1);
        //T nuevo = new HashPaciente()
        //Agregar la funcion de atender.
        if (tabla[posicion] == null) {
            tabla[posicion] = nuevo;
            add = true;
            porcentaje--;
        } else if (tabla[posicion].getLong() == nuevo.getHash()) {
//            if (tabla[posicion].getPaciente().getSegundo_nombre().equals(nuevo.getPaciente().getSegundo_nombre())) {
//                System.out.println("Ese paciente ya esta en la tabla.");
//            } else {
//                int j = 1;
//                for (int i = posicion + (j * j); i < largo; i++) {
//                    if (tabla[i] == null) {
//                        tabla[posicion + (i * i)] = nuevo;
//                        add = true;
//                        porcentaje--;
//                        
//                        break;
//
//                    }
//                    j++;
//                }
//
//            }
            
        }

        if (!add || porcentaje < (largo / 2)) {
            T[] auxiliar = (T[]) new HashPaciente[largo * 2];
            auxiliar = (T[]) resize(this.largo, (HashPaciente[]) tabla);
            tabla = (T[]) new HashPaciente[this.largo];
            this.tabla = auxiliar;
        }
    }

    private HashPaciente[] resize(int largo, HashPaciente[] tabla) {
        int nuevoL = largo * 2;
        HashPaciente[] nuevaT = new HashPaciente[nuevoL];
        for (int i = 0; i < tabla.length; i++) {
            nuevaT[i] = tabla[i];
        }
        this.largo = nuevoL;
        return nuevaT;
    }

    public String size() {
        return "El tamaño de la tabla es de: "+this.largo;
    }

    public void print() {
        for (int i = 0; i < largo; i++) {
            if (tabla[i] != null) {
                System.out.println(tabla[i].toString());
            }
        }
    }

    public int SearchName(String Primer_nombre, String Primer_apellido) {
        String First = Primer_nombre.substring(1, Primer_nombre.length() - 2);
        String First_A = Primer_apellido.substring(1, Primer_apellido.length() - 1);
        
        String cadena = First.concat(First_A);
        
        long hash = 0;
        int primo = 37;
        for (int i = 0; i < cadena.length(); i++) {
            char k = cadena.charAt(i);
            hash = (Primer_nombre.length() * Primer_apellido.length() - Primer_nombre.length()) * ((int) k) + hash;
        }
        hash = hash * (Primer_apellido.length() * Primer_apellido.length()) * primo + Primer_nombre.length();
        for (int i = 0; i < largo; i++) {
            if (hash == tabla[i].getLong()) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String Primer_nombre, String Primer_apellido) {

        int confirm = SearchName(Primer_nombre, Primer_apellido);
        if (confirm >= 0) {
            System.out.println(tabla[confirm].toString());

            tabla[confirm] = null;
            
        }else {
            System.out.println("No se ha encontrado el paciente");
        }
        

    }

    private long Tohash(T paciente) {
        String First = paciente.getString1().substring(1, paciente.getString1().length() - 2);
        String First_A = paciente.getString2().substring(1, paciente.getString2().length() - 1);
        
        String cadena = First.concat(First_A);
        
        long hash = 0;
        int primo = 37;
        for (int i = 0; i < cadena.length(); i++) {
            char k = cadena.charAt(i);
            hash = (paciente.getString1().length() * paciente.getString2().length() - paciente.getString1().length()) * ((int) k) + hash;
        }
        return hash * (paciente.getString2().length() * paciente.getString2().length()) * primo + paciente.getString1().length();
    }

   
    public void ExportarTabla(T Tabla) {
        File export = new File("C:\\Users\\walte");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(export));
            String dato ="";
            
        } catch (IOException e) {
        }
    }
    
    public void ImportarTabla(){}

}
