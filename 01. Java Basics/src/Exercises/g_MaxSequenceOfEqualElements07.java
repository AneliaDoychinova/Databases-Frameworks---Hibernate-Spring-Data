package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class g_MaxSequenceOfEqualElements07 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays
                .stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int lenght = 1;
        int maxLenght = 1;
        int maxLongNum = numbers[0];

        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i] == numbers[i-1]) {
                lenght++;

                if (maxLenght < lenght)
                {
                    maxLenght = lenght;
                    maxLongNum = numbers[i];
                }

            }
            else{
                lenght = 1;
            }

        }

        for (int i = 0; i < maxLenght; i++){
            System.out.print(maxLongNum + " ");
        }

    }
}
