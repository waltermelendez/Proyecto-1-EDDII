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
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author walte
 * @param <T>
 */
public class TXT<T extends number> {

    private File f;

    public TXT(File f) {
        this.f = f;
    }

    //Esta funcion es para el arbol b+
    public  ArrayList<T> importar(String direccion) {
        File archivo = new File(direccion);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String[] cadena = new String[7];
            String dato;
            int numero = 0;

            ArrayList<T> list = new ArrayList<>();
            try {
                leer.readLine();
                while ((dato = leer.readLine()) != null) {

                    cadena = dato.split(",");

                    try {
                        numero = Integer.parseInt(cadena[0].trim());
                        T nuevo = (T) new Paciente(numero, cadena[1], cadena[2], cadena[3], cadena[4], cadena[5], cadena[6]);
                        list.add(nuevo);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "No Ho hay suficiente informacion de este paciente");

                    }

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

   
    

    //Funcion para el arbol, no debe de devolver nada, fusionar con la funcion de borrar del arbol
    public  ArrayList<T> borrar(String direccion, ArrayList<T> lista) {

        File archivo = new File(direccion);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String[] cadena = new String[2];
            String dato;
            int numero = 0;
            try {
                leer.readLine();
                while ((dato = leer.readLine()) != null) {
                    cadena = dato.split(",");
                    try {
                        numero = Integer.parseInt(cadena[0].trim());
                        for (T paciente : lista) {
                            if (paciente.getNumber() == numero) {
                                lista.remove(paciente);
                                return lista;
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

    //Funcion para la tabla
    public void atender(String dir) {
        File archivo = new File(dir);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String[] cadena = new String[6];
            String dato;
            String[] auxiliar = new String[6];
            int id = 0;
            int prioridad = 0;
            ArrayList<T> hospital = new ArrayList<>();

            try {
                leer.readLine();
                while ((dato = leer.readLine()) != null) {
                    cadena = dato.split(",");
                    auxiliar = cadena[0].split(" ");

                    switch (auxiliar[0]) {
                        case "ID:" -> {
                            id = Integer.parseInt(auxiliar[1].trim());
                            auxiliar = cadena[1].split(" ");
                            // System.out.println(id);
                            prioridad = Integer.parseInt(auxiliar[2].trim());
                            //System.out.println(prioridad);
                            T nuevo = (T) new HashPaciente();
                            // nuevo.setPrioridad(prioridad);
                            //Hacer la funcion buscar id para el arbol b+
                        }
                        case "NOMBRES:" -> {
                            
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, "Dato del paciente no reconocido");
                        }
                    }
                }
                leer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se puede leer el archivo.");
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo a leer.");
        }
    }

    private long Tohash(Paciente paciente) {
        String First = paciente.getPrimer_nombre().substring(1, paciente.getPrimer_nombre().length() - 2);
        String First_A = paciente.getPrimer_apellido().substring(1, paciente.getPrimer_apellido().length() - 1);

        String cadena = First.concat(First_A);

        long hash = 0;
        int primo = 37;
        for (int i = 0; i < cadena.length(); i++) {
            char k = cadena.charAt(i);
            hash = (paciente.getPrimer_nombre().length() * paciente.getPrimer_apellido().length() - paciente.getPrimer_nombre().length()) * ((int) k) + hash;
        }
        return hash * (paciente.getPrimer_apellido().length() * paciente.getPrimer_apellido().length()) * primo + paciente.getPrimer_nombre().length();
    }


}
