package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a_VariableInHexadecimalFormat01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String hexadecimal = bf.readLine();
        Integer decimal = Integer.parseInt(hexadecimal,16);
        System.out.println(decimal);
    }
}
