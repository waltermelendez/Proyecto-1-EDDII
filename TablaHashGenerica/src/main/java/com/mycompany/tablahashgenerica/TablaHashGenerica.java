/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tablahashgenerica;

import java.util.ArrayList;

/**
 *
 * @author walte
 */
public class TablaHashGenerica {

    public static void main(String[] args) {
        ArrayList<Integer> tabla = new ArrayList<>();
        Paciente n = new Paciente(1546, 22, "Walter", "Francisco", "Melendez", "Aguilar", "20/2/2014", "meldenz");
        Paciente a = new Paciente(1246, 3, "Francisco", "Francsco", "Mlendez", "Aguar", "10/2/2014", "meenz");
        Paciente z = new Paciente(7546, 4, "Franco", "Daniel", "Hernandez", "Alvizurez", "20/2/2010", "meld");

        //Funcionamiento
        String F = "Franco";
        String H = "Hernandez";
        String A = "Alvizurez";
        String AA = A.substring(1, A.length() - 1);
        String HH = H.substring(1, H.length() - 1);
        String FF = F.substring(1, F.length() - 2);
        String cadena = AA.concat(HH).concat(FF);
        long hash = 0;
        int primo = 37;
        for (int i = 0; i < cadena.length(); i++) {
            char k = cadena.charAt(i);
            hash = (F.length() * H.length() - A.length()) * ((int) k) + hash;
        }
        System.out.println(z.Tohash());
        long[] tab = new long[11];
        for (int i = 0; i < 10; i++) {
            tab[i] = i;
        }
        long h = hash * (H.length() * A.length()) * primo + F.length();
        tab[8] = z.Tohash();
        tab[10] = 7815;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == h) {
                System.out.println("Se ha encontrado a " + "Franco" + "Daniel" + "Hernandez" + "Alvizurez");
            }
        }

        Paciente Aa = new Paciente(7546, 4, "Franco", "Ramon", "Hernandez", "Alvizurez", "24/2/2010", "f@5566");
        ArrayList<Long> ww = new ArrayList<>();
        ww.add(n.Tohash());
        ww.add(a.Tohash());
        ww.add(z.Tohash());
        ww.add(Aa.Tohash());
        for (int i = 0; i < ww.size(); i++) {
            System.out.println(ww.get(i).toString());
        }
        

    }
}
