/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.importarexportartxt;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author walte
 */
public class ImportarExportarTXT {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        File nuevo = new File("C:\\Users\\walte\\Desktop\\crear.txt");
        String dir = "C:\\Users\\walte\\Desktop\\crear.txt";
        TXT T = new TXT(nuevo);

        ArrayList<Paciente> nueva = new ArrayList<>();
        nueva.addAll(T.importar(dir));
        for (Paciente nueva1 : nueva) {
            System.out.println(nueva1.toString());
        }
        System.out.println("Metodo para borrar");
        ArrayList<Paciente> auxiliar = new ArrayList<>();
        //auxiliar.addAll(T.borrar(borrar, nueva));
        for (Paciente auxiliar1 : auxiliar) {
            System.out.println(auxiliar1.toString());
        }
        String atender="C:\\Users\\walte\\Desktop\\atencion.txt";
        T.atender(atender);

    }
}
