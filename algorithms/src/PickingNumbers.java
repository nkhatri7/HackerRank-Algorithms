// Neil Khatri
// HackerRank – Picking Numbers
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/picking-numbers/problem

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class PickingNumbers {
    static int pickingNumbers(List<Integer> a) {
        int maxLength = 0;

        Collections.sort(a);

        for (int i = 0; i < (a.size() - 1); i++) {
            int length = 0;
            for (int j = i; j < a.size(); j++) {
                int difference = a.get(j) - a.get(i);
                if (difference <= 1) {
                    length++;
                } else {
                    break;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
