package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_Client {
    public static void main(String[] args){
        for (int i = 1; i <= 5; i ++) {
            System.out.println("Run: " + i);
            for (int n = 10; n < 100000; n *= 5) {
                int connections = count(n);
                System.out.println("Number of connections generated: " + connections + ", n = " + n);
            }
        }
    }

    public static int count(int n){
        int connections = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n,true);
        Random rand = new Random();

        while (uf.components() != 1) {
            int num1 = rand.nextInt(n);
            int num2 = rand.nextInt(n);
            if (num1 != num2 && !uf.connected(num1, num2)) {
                uf.union(num1, num2);
            }
            connections ++;
        }
        return connections;
    }
}
