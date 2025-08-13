/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package clases.finnal;

import java.util.Scanner;

/**
 *
 * @author walter
 */
public class Finnal {

    public static void main(String[] args) {
        int est, grado;
        boolean estado = true;
        Scanner var = new Scanner(System.in);

        int ID, prioridad;
        String Primer_nombre, Segundo_nombre, Primer_apellido, Segundo_apellido, Fecha_nacimiento, Correo_electronico;
        boolean whi=true;
        do {
            System.out.println("Que quiere hacer");
            System.out.println("1.Importar registro");
            System.out.println("2.Crear nuevo registro");
            System.out.println("3.Salir");

            est = var.nextInt();
            switch (est) {
                case 1 -> {
                    System.out.println("que grado quiere que sea el arbol");
                    grado = var.nextInt();
                }
                case 2 -> {
                    System.out.println("que grado quiere que sea el arbol");
                    grado = var.nextInt();
                    BPlusTree arbol = new BPlusTree(grado);
                    while (whi) {
                        
                    }

                }
                case 3 -> {
                    estado = false;
                }
                default ->
                    estado = false;
            }
        } while (estado);
    }
}
