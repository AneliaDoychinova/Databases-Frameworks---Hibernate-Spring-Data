package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_CensorEmailAddress14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String email = bf.readLine();
        String text = bf.readLine();

        int indexOfEmail = email.indexOf('@');
        StringBuilder newEmail = new StringBuilder();
        for (int i = 0; i < indexOfEmail; i++) {
            newEmail.append("*");

        }
        newEmail.append(email.substring(indexOfEmail));

        text = text.replaceAll(email, newEmail.toString() );
        System.out.println(text);
    }
}
