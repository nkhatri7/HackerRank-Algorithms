// Neil Khatri
// HackerRank – Lisa's Workbook
// Attempted 03/06/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/lisa-workbook/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class LisasWorkbook {
    private static int workbook(int n, int k, List<Integer> arr) {
        int currentPage = 1;
        int specialProblems = 0;
        for (Integer chapterChallenges : arr) {
            // Iterate through each challenge in a chapter
            // i is the challenge number
            for (int i = 1; i <= chapterChallenges; i++) {
                if (i == currentPage) {
                    specialProblems++;
                }

                // New page if challenges reach max amount of challenges per
                // page unless challenge is the last challenge in the chapter
                // because the page is incremented in line 33
                if (((i % k == 0) || i == k) && i != chapterChallenges) {
                    currentPage++;
                }
            }

            // Start new chapter on new page
            currentPage++;
        }

        return specialProblems;
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

        List<Integer> arr = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
