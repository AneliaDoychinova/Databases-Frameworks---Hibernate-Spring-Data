package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e_IntegerToHexAndBinary05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int decimaNum = Integer.parseInt(bf.readLine());
        String hexadecimal = Integer.toHexString(decimaNum);
        String binary = Integer.toBinaryString(decimaNum);
        System.out.println(hexadecimal.toUpperCase());
        System.out.println(binary);
    }
}
