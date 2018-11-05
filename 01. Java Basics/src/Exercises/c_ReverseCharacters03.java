package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c_ReverseCharacters03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String char1 = bf.readLine();
        String char2 = bf.readLine();
        String char3 = bf.readLine();
        System.out.printf("%s%s%s",char3,char2,char1);
    }
}
