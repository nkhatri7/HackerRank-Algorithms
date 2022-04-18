// Neil Khatri
// HackerRank – Hurdle Race
// Attempted 18/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/the-hurdle-race/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class HurdleRace {
    static int hurdleRace(int k, List<Integer> height) {
        int doses = 0;
        int maxHeight = k;

        for (int hurdleHeight : height) {
            int difference = hurdleHeight - maxHeight;
            if (difference > 0) {
                doses += difference;
                maxHeight += difference;
            }
        }

        return doses;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> height = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
