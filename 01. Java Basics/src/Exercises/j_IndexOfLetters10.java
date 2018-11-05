package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class j_IndexOfLetters10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] word = bf.readLine().toCharArray();

        for (int i = 0;i < word.length;i++){
            int index = (int)word[i] - 97;
            System.out.printf("%c -> %d\n", word[i], index);
        }

    }
}
