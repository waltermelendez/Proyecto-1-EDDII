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

    public void Add(HashPaciente hash) {
        //Poner valores a reciver el primer nombre el primer apellido y el segundo apellido
        boolean add = false;
        int posicion = (int) (hash.getHash() % this.largo);
        if (tabla[posicion] == null) {
            tabla[posicion] = hash;
            add = true;
            porcentaje--;
        } else if (tabla[posicion] == hash) {
            int j = 1;
            for (int i = posicion + (j * j); i < largo; i++) {
                if (tabla[i] == null) {
                    tabla[posicion + (i * i)] = hash;
                    add = true;
                    porcentaje--;
                    SaveEquals(i);
                    SaveEquals(posicion);
                    break;

                }
                j++;
            }
            if (!add) {
                for (int i = 0; i < largo; i++) {
                    if (tabla[i] == null) {
                        tabla[i] = hash;
                        add = true;
                        porcentaje--;
                        SaveEquals(i);
                        SaveEquals(posicion);
                        break;
                    }
                }
            }
        }

        if (!add || porcentaje < (largo / 3)) {
            HashPaciente[] auxiliar = new HashPaciente[largo * 2];
            auxiliar = resize(this.largo, tabla);
            tabla = new HashPaciente[this.largo * 2];
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

    public int size() {
        return this.largo;
    }

    public void print() {
        for (int i = 0; i < largo; i++) {
            if (tabla[i]!=null) {
                System.out.println(tabla[i].getHash() + " " + tabla[i].toString());
            }
        }
    }

    private void SaveEquals(int i) {
        for (int j = 0; j < iguales.length; j++) {
            if (iguales[j] == -1) {
                iguales[j] = i;
                break;
            }
        }
    }

    public boolean SearchName(String Primer_nombre, String Primer_apellido, String Segundo_apellido) {
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
                return true;
            }
        }
        return false;
    }

    public boolean delete(HashPaciente hash) {
        //Poner valores a reciver el primer nombre el primer apellido y el segundo apellido
        for (int i = 0; i < largo; i++) {
            if (tabla[i] == hash) {
               tabla[i]=null;
               return true;
            }
        }
        return false;
    }
    
    
    public long Tohash(String Primer_nombre, String Primer_apellido, String Segundo_apellido) {
        String First = Primer_nombre.substring(1, Primer_nombre.length() - 2);
        String First_A = Primer_apellido.substring(1,Primer_apellido.length()-1);
        String Second_N = Segundo_apellido.substring(1, Segundo_apellido.length()-1);
        String cadena = First.concat(First_A);
        cadena = cadena.concat(Second_N);
        long hash=0;
        int primo=37;
        for (int i = 0; i < cadena.length(); i++) {
            char k= cadena.charAt(i);
           hash= (Primer_nombre.length()*Primer_apellido.length()-Segundo_apellido.length())*((int)k )+hash;
        }
        return hash*(Primer_apellido.length()*Segundo_apellido.length())*primo+Primer_nombre.length();
    }
}
