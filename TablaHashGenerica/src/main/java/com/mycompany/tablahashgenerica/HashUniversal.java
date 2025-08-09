/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tablahashgenerica;

/**
 *
 * @author walte
 */
public class HashUniversal {

    private long a;
    private long b;
    private long m;
    private long p;

    public HashUniversal(long a, long b, long p, long m) {
        this.p = p;
        this.m = m + p;
        if (a >= 1 && (a <= p - 1)) {
            this.a = a;
        }

        if (0 <= b && (b < p)) {

        }

    }
     public long hashint(long key) {
        long hash = (a * key + b) % p;
        if (hash < 0) {
            hash = hash + p;

        }
        return hash % m;
    }
     
     
}
