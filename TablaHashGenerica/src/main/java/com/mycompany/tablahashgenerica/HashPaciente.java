/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tablahashgenerica;

/**
 *
 * @author walte
 */
public class HashPaciente {

    private Paciente paciente;
    private long hash;

    public HashPaciente(Paciente paciente, long hash) {
        this.paciente = paciente;
        this.hash = hash;
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
    
    

}
