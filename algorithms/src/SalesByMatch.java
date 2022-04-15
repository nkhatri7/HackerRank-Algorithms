// Neil Khatri
// HackerRank – Sales By Match
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/sock-merchant/problem

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class SalesByMatch {
    public static int sockMerchant(int n, List<Integer> ar) {
        int pairs = 0;

        Collections.sort(ar);

        for (int i = 0; i < (n - 1); i++) {
            if (ar.get(i).equals(ar.get(i + 1))) {
                pairs++;
                i++;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedWriter.flush();

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ar = Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = sockMerchant(n, ar);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
