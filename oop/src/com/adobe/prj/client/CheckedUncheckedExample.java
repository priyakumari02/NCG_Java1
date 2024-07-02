package com.adobe.prj.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedUncheckedExample {
    public static void main(String[] args) {
        checked();
        unchecked();
    }

    private static void unchecked() {
        int[] data = {4,1,54};
        System.out.println(data[8]); // compiler compiles
    }

    private static void checked() {
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
