// Neil Khatri
// HackerRank – Cut the Sticks
// Attempted 21/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/cut-the-sticks/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CutTheSticks {
    static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> sticks = new ArrayList<>(arr);
        List<Integer> itemsLeft = new ArrayList<>();
        itemsLeft.add(sticks.size());

        while (sticks.size() > 1) {

            // Set size to number higher than constraints
            int smallestStick = 1001;

            // Find smallest stick
            for (Integer stick : sticks) {
                if (stick < smallestStick) {
                    smallestStick = stick;
                }
            }

            // Remove smallest sticks
            List<Integer> toRemove = new ArrayList<>();
            for (Integer stick : sticks) {
                if (stick == smallestStick) {
                    toRemove.add(stick);
                }
            }
            sticks.removeAll(toRemove);

            // Update sizes of remaining sticks
            for (int i = 0; i < sticks.size(); i++) {
                if (sticks.get(i) != smallestStick) {
                    sticks.set(i, (sticks.get(i) - smallestStick));
                }
            }
            if (sticks.size() > 0) {
                itemsLeft.add(sticks.size());
            }
        }

        return itemsLeft;
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

        List<Integer> result = cutTheSticks(arr);

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
