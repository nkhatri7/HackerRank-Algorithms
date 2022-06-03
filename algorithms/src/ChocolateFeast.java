// Neil Khatri
// HackerRank – Chocolate Bar
// Attempted 03/06/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/chocolate-feast/problem

import java.io.*;
import java.util.stream.*;

public class ChocolateFeast {
    private static int chocolateFeast(int n, int c, int m) {
        int wrappers = 0;
        int boughtChocolates = n / c;
        wrappers = boughtChocolates;

        while (wrappers >= m) {
            wrappers -= m;
            wrappers++;
            boughtChocolates++;
        }

        return boughtChocolates;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int c = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = chocolateFeast(n, c, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
