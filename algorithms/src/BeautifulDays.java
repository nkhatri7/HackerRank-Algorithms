// Neil Khatri
// HackerRank – Beautiful Days at the Movies
// Attempted 18/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

import java.io.*;

public class BeautifulDays {
    static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;

        for (int start = i; start <= j; start++) {
            String numberString = String.valueOf(start);
            StringBuilder sb = new StringBuilder(numberString);
            String reverseString = sb.reverse().toString();

            int num = Integer.parseInt(numberString);
            int reverseNum = Integer.parseInt(reverseString);
            int difference = Math.abs(num - reverseNum);
            if (difference % k == 0) {
                beautifulDays++;
            }
        }

        return beautifulDays;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
