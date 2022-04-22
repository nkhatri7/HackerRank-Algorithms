// Neil Khatri
// HackerRank – Equalize the Array
// Attempted 22/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/equality-in-a-array/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class EqualiseTheArray {
    static int equalizeArray(List<Integer> arr) {
        int max = 1;
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int num : arr) {
            if (!numbers.containsKey(num)) {
                numbers.put(num, 1);
            } else {
                numbers.put(num, numbers.get(num) + 1);
                if (numbers.get(num) > max) {
                    max = numbers.get(num);
                }
            }
        }

        return arr.size() - max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
