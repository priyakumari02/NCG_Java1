package com.adobe.orderapp.util;

public class ArrayUtil {
    public static int getMax(int[] elems) {
        int max = elems[0];
        for(int elem : elems) {
            if(elem > max) {
                max = elem;
            }
        }
        return  max;
    }

    public static void sort(int[] elems) {
        for (int i = 0; i < elems.length; i++) {
            for (int j = i+1; j < elems.length; j++) {
                if(elems[i] > elems[j]) {
                    int swap = elems[i];
                    elems[i] = elems[j];
                    elems[j] = swap;
                }
            }
        }
    }
}
