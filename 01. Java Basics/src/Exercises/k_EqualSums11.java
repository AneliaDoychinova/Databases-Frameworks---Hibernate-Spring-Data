package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class k_EqualSums11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int leftSum;
        int rightSum = 0;
        int currentSum = 0;
        int indexEqualSum = 0;
        boolean isEqualSum = false;

        for (int i = 0; i < numbers.length; i++)
        {
            leftSum = currentSum;
            for (int j = i+1; j < numbers.length; j++)
            {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum)
            {
                isEqualSum = true;
                indexEqualSum = i;
                break;
            }
            currentSum += numbers[i];
            rightSum = 0;

        }
        if (isEqualSum)
        {
            System.out.println(indexEqualSum);
        }
        else
        {
            System.out.println("no");
        }
    }
}
