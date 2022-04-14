// Neil Khatri
// HackerRank – Subarray Division
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/the-birthday-bar/problem

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class SubarrayDivision {
    public static int birthday(List<Integer> s, int d, int m) {
        int noOfWays = 0;

        if (s.size() != 1) {
            for (int i = 0; i < (s.size() - (m - 1)); i++) {
                int sum = 0;
                for (int j = i; j < (i + m); j++) {
                    sum += s.get(j);
                }
                if (sum == d) {
                    noOfWays++;
                }
            }
        } else if (s.get(0) == d) {
            noOfWays++;
        }

        return noOfWays;
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedWriter.flush();

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "")
                    .split(" ");

            int d = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int result = birthday(s, d, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
