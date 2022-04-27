// Neil Khatri
// HackerRank – Between Two Sets
// Attempted 28/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/between-two-sets/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class BetweenTwoSets {
    private static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcm = lcm(a);
        int gcd = gcd(b);
        int count = 0;

        for (int i = lcm, j = 2; i <= gcd; i = (lcm * j), j++) {
            if (gcd % i == 0) {
                count++;
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private static int gcd(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = gcd(result, arr.get(i));
        }

        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = lcm(result, arr.get(i));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
