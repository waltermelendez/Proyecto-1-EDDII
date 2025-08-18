/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

/**
 *
 * @author walte
 * @param <T>
 */
public class HashPaciente <T> implements Table{

    private String Primer_Nombre;
    private String Primer_Apellido;
    private long hash;
    private int prioridad;

    public HashPaciente(String Primer_Nombre, String Primer_Apellido, long hash, int prioridad) {
        this.Primer_Nombre = Primer_Nombre;
        this.Primer_Apellido = Primer_Apellido;
        this.hash = hash;
        this.prioridad = prioridad;
    }

    public String getPrimer_Nombre() {
        return Primer_Nombre;
    }

    public void setPrimer_Nombre(String Primer_Nombre) {
        this.Primer_Nombre = Primer_Nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String Primer_Apellido) {
        this.Primer_Apellido = Primer_Apellido;
    }


    public HashPaciente() {
    }

    public long getHash() {
        return hash;
    }

    

    public void setHash(long hash) {
        this.hash = hash;
    }

    

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "HashPaciente{" + "Primer_Nombre=" + Primer_Nombre + ", Primer_Apellido=" + Primer_Apellido + ", hash=" + hash + ", prioridad=" + prioridad + '}';
    }

    @Override
    public String getString1() {
        return this.Primer_Nombre;
    }

    @Override
    public String getString2() {
        return this.Primer_Apellido;
    }

    @Override
    public long getLong() {
        return this.hash;
    }

    

    
}
