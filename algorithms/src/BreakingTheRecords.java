// Neil Khatri
// HackerRank – Breaking the Records (Implementation)
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingTheRecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = scores.get(0);
        int max = scores.get(0);
        int minBroken = 0;
        int maxBroken = 0;

        for (int score: scores) {
            if (score < min) {
                min = score;
                minBroken++;
            }
            if (score > max) {
                max = score;
                maxBroken++;
            }
        }

        return new ArrayList<Integer>(Arrays.asList(maxBroken, minBroken));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
