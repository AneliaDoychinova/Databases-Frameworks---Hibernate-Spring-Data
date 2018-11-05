package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_ChangeToUppercase16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder solution = new StringBuilder(bf.readLine());

        int start = solution.indexOf("<upcase>");

        while (start > -1) {

            int end = solution.indexOf("</upcase>");

            String needsToUpper = solution.substring(start + 8, end);

            String toUpper = needsToUpper.toUpperCase();

            solution.replace(start, end + 9, toUpper);

            start = solution.indexOf("<upcase>");
        }

        System.out.println(solution);
    }
}
