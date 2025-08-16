/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tablahashgenerica;

/**
 *
 * @author walte
 */
public class Tabla {

    private HashPaciente[] tabla;
    private int largo;
    private int porcentaje;
    private final int[] iguales;

    public Tabla(int largo) {
        this.tabla = new HashPaciente[largo];
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

    public void Add(Paciente hash) {
        boolean add = false;
        int posicion = (int) (Tohash(hash) % this.largo);
        HashPaciente nuevo = new HashPaciente(hash, Tohash(hash));
        if (tabla[posicion] == null) {
            tabla[posicion] = nuevo;
            add = true;
            porcentaje--;
        } else if (tabla[posicion].getHash() == nuevo.getHash()) {
            if (tabla[posicion].getPaciente().getSegundo_nombre().equals(nuevo.getPaciente().getSegundo_nombre())) {
                System.out.println("Ese paciente ya esta en la tabla.");
            } else {
                int j = 1;
                for (int i = posicion + (j * j); i < largo; i++) {
                    if (tabla[i] == null) {
                        tabla[posicion + (i * i)] = nuevo;
                        add = true;
                        porcentaje--;
                        
                        break;

                    }
                    j++;
                }

            }
            
        }

        if (!add || porcentaje < (largo / 2)) {
            HashPaciente[] auxiliar = new HashPaciente[largo * 2];
            auxiliar = resize(this.largo, tabla);
            tabla = new HashPaciente[this.largo];
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
                System.out.println(tabla[i].getHash() + " " + tabla[i].toString());
            }
        }
    }

    public int SearchName(String Primer_nombre, String Primer_apellido, String Segundo_apellido) {
        String First = Primer_nombre.substring(1, Primer_nombre.length() - 2);
        String First_A = Primer_apellido.substring(1, Primer_apellido.length() - 1);
        String Second_N = Segundo_apellido.substring(1, Segundo_apellido.length() - 1);
        String cadena = First.concat(First_A);
        cadena = cadena.concat(Second_N);
        long hash = 0;
        int primo = 37;
        for (int i = 0; i < cadena.length(); i++) {
            char k = cadena.charAt(i);
            hash = (Primer_nombre.length() * Primer_apellido.length() - Segundo_apellido.length()) * ((int) k) + hash;
        }
        hash = hash * (Primer_apellido.length() * Segundo_apellido.length()) * primo + Primer_nombre.length();
        for (int i = 0; i < largo; i++) {
            if (hash == tabla[i].getHash()) {
                return i;
            }
        }
        return -1;
    }

    public Paciente delete(String Primer_nombre, String Primer_apellido, String Segundo_apellido) {

        int confirm = SearchName(Primer_nombre, Primer_apellido, Segundo_apellido);
        if (confirm >= 0) {
            Paciente nuevo = tabla[confirm].getPaciente();

            tabla[confirm] = null;
            return nuevo;
        }
        return null;

    }

    private long Tohash(Paciente paciente) {
        String First = paciente.getPrimer_nombre().substring(1, paciente.getPrimer_nombre().length() - 2);
        String First_A = paciente.getPrimer_apellido().substring(1, paciente.getPrimer_apellido().length() - 1);
        String Second_N = paciente.getSegundo_apellido().substring(1, paciente.getSegundo_apellido().length() - 1);
        String cadena = First.concat(First_A);
        cadena = cadena.concat(Second_N);
        long hash = 0;
        int primo = 37;
        for (int i = 0; i < cadena.length(); i++) {
            char k = cadena.charAt(i);
            hash = (paciente.getPrimer_nombre().length() * paciente.getPrimer_apellido().length() - paciente.getSegundo_apellido().length()) * ((int) k) + hash;
        }
        return hash * (paciente.getPrimer_apellido().length() * paciente.getSegundo_apellido().length()) * primo + paciente.getPrimer_nombre().length();
    }

   

}
