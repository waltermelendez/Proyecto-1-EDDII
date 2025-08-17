/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.importarexportartxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author walte
 */
public class TXT {

    private File f;

    public TXT(File f) {
        this.f = f;
    }

    public ArrayList importar(String direccion) {
        File archivo = new File(direccion);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String[] cadena = new String[7];
            String dato;
            int numero = 0;

            ArrayList<Paciente> list = new ArrayList<>();
            try {
                leer.readLine();
                while ((dato = leer.readLine()) != null) {

                    cadena = dato.split(",");
                    Paciente nuevo = new Paciente();

                    try {
                        numero = Integer.parseInt(cadena[0].trim());
                        nuevo.setID(numero);
                    } catch (NumberFormatException e) {
                        numero = 0;
                        nuevo.setID(numero);
                    }
                    nuevo.setPrimer_nombre(cadena[1]);
                    nuevo.setSegundo_nombre(cadena[2]);
                    nuevo.setPrimer_apellido(cadena[3]);
                    nuevo.setSegundo_nombre(cadena[4]);
                    nuevo.setFecha_nacimiento(cadena[5]);
                    nuevo.setCorreo_electronico(cadena[6]);
                    list.add(nuevo);
                }
                leer.close();
                return list;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo");
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        }
        return null;
    }

    public void exportar(String direccion) {
        File archivo = new File(direccion);
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
            escribir.write("");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la escritura");
        }
    }

    public ArrayList<Paciente> borrar(String direccion,ArrayList<Paciente> Pacientes) {
        boolean delete=false;
        File archivo = new File(direccion);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String[] cadena = new String[2];
            String dato;
            int numero = 0;
            try {
                leer.readLine();
                while ((dato=leer.readLine())!=null) {
                    cadena = dato.split(",");
                    try {
                        numero = Integer.parseInt(cadena[0].trim());
                        for (Paciente Paciente : Pacientes) {
                            if (Paciente.getID()==numero) {
                                Pacientes.remove(Paciente);
                                return Pacientes;
                            }
                        }
                        
                    } catch (NumberFormatException e) {
                         JOptionPane.showMessageDialog(null, "No se encontro el ID a eliminar");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No es posible leer el archivo.");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo.");
        }
        return null;
    }
}
