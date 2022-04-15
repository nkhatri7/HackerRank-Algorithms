// Neil Khatri
// HackerRank – Divisible Sum Pairs
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class DivisibleSumPairs {
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Sort list in ascending order
        Collections.sort(ar);
        int sumPairs = 0;

        for (int i = 0; i < (n - 1); i++) {
            for (int j = (i + 1); j < n; j++) {
                int sum = ar.get(i) + ar.get(j);
                if (sum % k == 0) {
                    sumPairs++;
                }
            }
        }

        return sumPairs;
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedWriter.flush();

            String[] firstMultipleInput = bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> ar = Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = divisibleSumPairs(n, k, ar);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
