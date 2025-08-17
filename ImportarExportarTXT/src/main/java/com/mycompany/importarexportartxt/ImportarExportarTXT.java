/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.importarexportartxt;

import java.io.File;

/**
 *
 * @author walte
 */
public class ImportarExportarTXT {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        File nuevo = new File("C:\\Users\\walte\\Desktop\\crear.txt");
        String dir ="C:\\Users\\walte\\Desktop\\crear.txt";
        TXT T = new TXT(nuevo);
        System.out.println(nuevo.exists());
        System.out.println(T.importar(dir).toString());
        
        
    }
}
