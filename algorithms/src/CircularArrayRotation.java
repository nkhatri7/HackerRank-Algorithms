// Neil Khatri
// HackerRank – Circular Array Rotation
// Attempted 19/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/circular-array-rotation/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CircularArrayRotation {
    static List<Integer> circularArrayRotation(List<Integer> a, int k,
            List<Integer> queries) {
        List<Integer> rotation = new ArrayList<>(a);

        for (int i = 0; i < a.size(); i++) {
            int position = (i + k) % a.size();
            rotation.set(position, a.get(i));
        }

        List<Integer> extract = new ArrayList<>();
        // Add queries values to new list
        for (Integer query : queries) {
            extract.add(rotation.get(query));
        }

        return extract;
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

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = circularArrayRotation(a, k, queries);

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
