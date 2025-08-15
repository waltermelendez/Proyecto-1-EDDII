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
    
    public void importar(String direccion){
    File archivo = new File(direccion);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        }
    
    
    }
    public void exportar(String direccion){
    File archivo = new File(direccion);
        try {
            BufferedWriter escribir= new BufferedWriter( new FileWriter(archivo));
            escribir.write("");
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "Hubo un error en la escritura");
        }
    }
}
