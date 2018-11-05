package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class m_FitStringIn20Chars13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();
        StringBuilder solution = new StringBuilder();

        if(word.length()<20){
            solution.append(word);
            for (int i = 0; i < 20-word.length(); i++) {
                solution.append("*");

            }
        }
        else {
            solution.append(word.substring(0, 20));
        }

        System.out.println(solution);
    }
}
