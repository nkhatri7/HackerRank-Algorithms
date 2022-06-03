// Neil Khatri
// HackerRank – Service Lane
// Attempted 03/06/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/service-lane/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ServiceLane {
    private static List<Integer> serviceLane(int n, List<Integer> width,
                                             List<List<Integer>> cases) {
        List<Integer> minWidths = new ArrayList<>();
        for (List<Integer> segment : cases) {
            int minWidth = Integer.MAX_VALUE;
            int segmentStart = segment.get(0);
            int segmentEnd = segment.get(1);

            // Iterate through each case
            for (int i = segmentStart; i <= segmentEnd; i++) {
                // If the width for that part is less than the current min
                // change the min width to the new width
                if (width.get(i) < minWidth) {
                    minWidth = width.get(i);
                }
            }

            minWidths.add(minWidth);
        }

        return minWidths;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = serviceLane(n, width, cases);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
