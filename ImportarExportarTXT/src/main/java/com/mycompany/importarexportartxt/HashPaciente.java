/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

/**
 *
 * @author walte
 */
public class HashPaciente {

    private Paciente paciente;
    private long hash;
    private int prioridad;

    public HashPaciente(Paciente paciente, long hash, int prioridad) {
        this.paciente = paciente;
        this.hash = hash;
        this.prioridad = prioridad;
    }

    public HashPaciente() {
    }

    

    public long getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "HashPaciente{" + "paciente=" + paciente + '}';
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    

}
