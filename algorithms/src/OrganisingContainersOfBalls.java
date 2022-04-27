// Neil Khatri
// HackerRank – Organizing Containers of Balls
// Attempted 28/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class OrganisingContainersOfBalls {
    static String organisingContainers(List<List<Integer>> container) {
        Set<Integer> balls = container.stream()
                .map(b -> b.stream().mapToInt(Integer::intValue).sum())
                .collect(toSet());
        Set<Integer> types = IntStream.range(0, container.size())
                .mapToObj(t -> container.stream().mapToInt(b -> b.get(t)).sum())
                .collect(toSet());

        return balls.containsAll(types) ? "Possible" : "Impossible";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine()
                                        .replaceAll("\\s+$", "")
                                        .split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = organisingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
