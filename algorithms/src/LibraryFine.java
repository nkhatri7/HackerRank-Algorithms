// Neil Khatri
// HackerRank – Library Fine
// Attempted 21/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/library-fine/problem

import java.io.*;

public class LibraryFine {
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;

        if (y1 > y2) {
            fine = 10000;
        } else if (m1 > m2 && y1 == y2) {
            fine = 500 * (m1 - m2);
        } else if (d1 > d2 && m1 == m2 && y1 == y2) {
            fine = 15 * (d1 - d2);
        }

        return fine;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
