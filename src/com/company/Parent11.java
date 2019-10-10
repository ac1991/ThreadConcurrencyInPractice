package com.company;

public class Parent11 {
    Object lock = new Object();

    public synchronized int getK() {
        synchronized (lock) {
         System.out.print(k);
        }
        return k;
    }

    public synchronized void setK(int k) {
        this.k = k;
    }

    public synchronized int getJ() {
        synchronized (lock) {
            System.out.print(j);
        }
        return j;
    }

    public synchronized void setJ(int j) {
        this.j = j;
    }

    int k = 1;
    int j = 2;

}
