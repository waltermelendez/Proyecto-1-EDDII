/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolesbplus;

import org.json.JSONObject;

/**
 *
 * @author walte
 */
public class Paciente implements Comparable<Paciente> {

    private final int ID;
    private String Primer_nombre;
    private String Segundo_nombre;
    private String Primer_apellido;
    private String Segundo_apellido;
    private String Fecha_nacimiento;
    private String Correo_electronico;

    public Paciente(int ID, String Primer_nombre, String Segundo_nombre, String Primer_apellido, String Segundo_apellido, String Fecha_nacimiento, String Correo_electronico) {
        this.ID = ID;
        this.Primer_nombre = Primer_nombre;
        this.Segundo_nombre = Segundo_nombre;
        this.Primer_apellido = Primer_apellido;
        this.Segundo_apellido = Segundo_apellido;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.Correo_electronico = Correo_electronico;
    }

    public int getID() {
        return ID;
    }

    public JSONObject ToJson() {
        JSONObject paciente = new JSONObject();
        paciente.put("ID", this.ID);
        paciente.put("Primer_nombre", this.Primer_nombre);
        paciente.put("Segundo_nombre", this.Segundo_nombre);
        paciente.put("Primer_apellido", this.Primer_apellido);
        paciente.put("Segundo_apellido", this.Segundo_apellido);
        paciente.put("Fecha_nacimiento", this.Fecha_nacimiento);
        paciente.put("Correo_electronico", this.Correo_electronico);
        return paciente;
    }

    public static Paciente loadJson(JSONObject nueva) {
        return new Paciente(nueva.getInt("ID"), nueva.getString("Primer_nombre"),
                nueva.getString("Segundo_nombre"), nueva.getString("Primer_apellido"),
                nueva.getString("Segundo_apellido"), nueva.getString("Fecha_nacimiento"),
                nueva.getString("Correo_electronico"));
    }

    @Override
    public String toString() {
        return "Paciente{" + "ID=" + ID + ", Primer_nombre=" + Primer_nombre + ", Segundo_nombre=" + Segundo_nombre + ", Primer_apellido=" + Primer_apellido + ", Segundo_apellido=" + Segundo_apellido + ", Fecha_nacimiento=" + Fecha_nacimiento + ", Correo_electronico=" + Correo_electronico + '}';
    }

    @Override
    public int compareTo(Paciente o) {
        return Integer.compare(this.ID, o.ID);
    }

}
