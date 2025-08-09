/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.arbolesbplus;

import java.io.IOException;

/**
 *
 * @author walte
 */
public class ArbolesBPlus {

    public static void main(String[] args) {
        BPlusTree nuevo = new BPlusTree(3);
        Paciente n = new Paciente(1546, "Walter", "Francisco", "Melendez", "Aguilar", "20/2/2014", "meldenz");
        Paciente a = new Paciente(1246, "alter", "Francsco", "Mlendez", "Aguar", "10/2/2014", "meenz");
        Paciente z = new Paciente(7546, "Walr", "Franci", "Melend", "Alar", "20/2/2010", "meld");
        nuevo.insertar(n);
        nuevo.insertar(a);
        nuevo.insertar(z);
        nuevo.imprimirEnOrden();
        nuevo.saveToFile("Myson.json");
        BPlusTree dos = new BPlusTree(3);
        try {
            dos= dos.loadFromFile("C:\\Users\\walte\\Documents\\NetBeansProjects\\SprigbootProyects\\ArbolesBPlusWithObjectT\\Myson.json");
        } catch (IOException e) {
        }
        System.out.println("Dos:");
        dos.imprimirEnOrden();
        
        
       
            
    }
}
