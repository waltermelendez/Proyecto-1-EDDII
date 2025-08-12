/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tablahashgenerica;

/**
 *
 * @author walte
 */
public class Paciente implements Comparable<Paciente> {

    private final int ID;
    private int Prioridad;
    private String Primer_nombre;
    private String Segundo_nombre;
    private String Primer_apellido;
    private String Segundo_apellido;
    private String Fecha_nacimiento;
    private String Correo_electronico;

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

    public String tochain() {
        int id = this.ID;
        String P = this.Primer_nombre.substring(1, this.Primer_nombre.length() - 2);
        String S = this.Primer_apellido.substring(1, this.Primer_nombre.length() - 3);
       String C = this.Correo_electronico.substring(4,this.Correo_electronico.length()-5);
        return P.concat(S).concat(C);
    }

}
