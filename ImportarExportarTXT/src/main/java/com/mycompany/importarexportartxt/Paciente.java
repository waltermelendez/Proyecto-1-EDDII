/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

/**
 *
 * @author walte
 */
public class Paciente implements Comparable<Paciente> {

    private int ID;
    private int Prioridad;
    private String Primer_nombre;
    private String Segundo_nombre;
    private String Primer_apellido;
    private String Segundo_apellido;
    private String Fecha_nacimiento;
    private String Correo_electronico;

    public Paciente() {

    }

    public Paciente(int ID, int Prioridad, String Primer_nombre, String Segundo_nombre, String Primer_apellido, String Segundo_apellido, String Fecha_nacimiento, String Correo_electronico) {
        this.ID = ID;
        this.Prioridad = Prioridad;
        this.Primer_nombre = Primer_nombre;
        this.Segundo_nombre = Segundo_nombre;
        this.Primer_apellido = Primer_apellido;
        this.Segundo_apellido = Segundo_apellido;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.Correo_electronico = Correo_electronico;
    }

    @Override
    public String toString() {
        return "Paciente{" + "ID=" + ID + ", Prioridad=" + Prioridad + ", Primer_nombre=" + Primer_nombre + ", Segundo_nombre=" + Segundo_nombre + ", Primer_apellido=" + Primer_apellido + ", Segundo_apellido=" + Segundo_apellido + ", Fecha_nacimiento=" + Fecha_nacimiento + ", Correo_electronico=" + Correo_electronico + '}';
    }

    @Override
    public int compareTo(Paciente o) {
        return Integer.compare(this.ID, o.ID);
    }

    public int getID() {
        return ID;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public String getPrimer_nombre() {
        return Primer_nombre;
    }

    public String getSegundo_nombre() {
        return Segundo_nombre;
    }

    public String getPrimer_apellido() {
        return Primer_apellido;
    }

    public String getSegundo_apellido() {
        return Segundo_apellido;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public String getCorreo_electronico() {
        return Correo_electronico;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrioridad(int Prioridad) {
        this.Prioridad = Prioridad;
    }

    public void setPrimer_nombre(String Primer_nombre) {
        this.Primer_nombre = Primer_nombre;
    }

    public void setSegundo_nombre(String Segundo_nombre) {
        this.Segundo_nombre = Segundo_nombre;
    }

    public void setPrimer_apellido(String Primer_apellido) {
        this.Primer_apellido = Primer_apellido;
    }

    public void setSegundo_apellido(String Segundo_apellido) {
        this.Segundo_apellido = Segundo_apellido;
    }

    public void setFecha_nacimiento(String Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public void setCorreo_electronico(String Correo_electronico) {
        this.Correo_electronico = Correo_electronico;
    }
    
    

}
