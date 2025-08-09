/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package clases.monticulo;

import java.util.ArrayList;

/**
 *
 * @author walter
 */
public class Heap {

    public static void main(String[] args) {
        Paciente n = new Paciente(1546, 12,"Walter", "Francisco", "Melendez", "Aguilar", "20/2/2014", "meldenz");
        Paciente a = new Paciente(1246,1 ,"alter", "Francsco", "Mlendez", "Aguar", "10/2/2014", "meenz");
        Paciente z = new Paciente(7546, 22,"Walr", "Franci", "Melend", "Alar", "20/2/2010", "meld");
        ArrayList<Paciente> nu = new ArrayList<>();
        nu.add(z);
        nu.add(a);
        Monticulo nuevo = new Monticulo(nu);

       
        nuevo.Imprimir();
        //https://aprendeyprogramablog.wordpress.com/2016/10/19/monticulos/
    }
}
