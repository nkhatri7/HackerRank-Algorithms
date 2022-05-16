// Neil Khatri
// HackerRank – Minimum Distances
// Attempted 16/05/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/minimum-distances/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MinimumDistances {
    private static int minimumDistances(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        int currentIndex = 0;
        int prevIndex = 0;

        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey((a.get(i)))) {
                currentIndex = i;
                prevIndex = map.get(a.get(i));
                minDistance = Math.min((currentIndex - prevIndex), minDistance);
            }

            map.put(a.get(i), i);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
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

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
