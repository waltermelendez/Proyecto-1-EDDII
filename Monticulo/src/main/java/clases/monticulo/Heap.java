/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package clases.monticulo;

/**
 *
 * @author walter
 */
public class Heap {

    public static void main(String[] args) {
        Monticulo nuevo = new Monticulo(3,9);
        
        nuevo.insert(2);
        nuevo.insert(4);
        nuevo.insert(5);
        nuevo.insert(8);
        System.out.println(nuevo.peek());
        System.out.println(nuevo.first());
        //https://aprendeyprogramablog.wordpress.com/2016/10/19/monticulos/
    }
}
