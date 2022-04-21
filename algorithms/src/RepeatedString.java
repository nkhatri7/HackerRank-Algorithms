// Neil Khatri
// HackerRank – Repeated String
// Attempted 22/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/repeated-string/problem

import java.io.*;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        long count = 0;

        // Count the number of a's in provided string
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }

        // Calculate the number of times the string would fit into the integer
        long factor = n / s.length();
        // Calculate the number of characters that would be left over
        long remainder = n % s.length();
        /* Multiply the count by the factor to get number of a's from the whole
           string multiplied factor times */
        count *= factor;

        // Count the number of a's that would be in the remaining characters
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
