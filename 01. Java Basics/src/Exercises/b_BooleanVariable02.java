package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_BooleanVariable02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        boolean bool = Boolean.parseBoolean(input);
        if (bool){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
