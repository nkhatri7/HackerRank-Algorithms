// Neil Khatri
// HackerRank – Migratory Birds
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/migratory-birds/problem

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        Collections.sort(arr);
        int type = 0;
        int maxSightings = 0;

        for (int i = 0; i < (arr.size() - 1); i++) {
            int sightings = 0;
            for (int j = (i + 1); j < arr.size(); j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    sightings++;
                } else {
                    break;
                }
            }
            if (sightings > maxSightings) {
                maxSightings = sightings;
                type = arr.get(i);
            }
        }

        return type;
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedWriter.flush();

            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = migratoryBirds(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
