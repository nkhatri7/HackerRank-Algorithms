// Neil Khatri
// HackerRank – Taum and B'day
// Attempted 28/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/taum-and-bday/problem

import java.io.*;
import java.util.stream.*;

public class TaumAndBday {
    static long taumBday(int b, int w, int bc, int wc, int z) {
        bc = (bc - wc) > z ? wc + z : bc;
        wc = (wc - bc) > z ? bc + z : wc;
        long price = (long) b * bc + (long) w * wc;
        return price;
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

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = taumBday(b, w, bc, wc, z);

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
