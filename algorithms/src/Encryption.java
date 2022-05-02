// Neil Khatri
// HackerRank – Encryption
// Attempted 30/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/encryption/problem

import java.io.*;

public class Encryption {
    private static String encryption(String s) {
        // Remove spaces
        String noSpaces = s.replaceAll("\\s+", "");

        int length = noSpaces.length();
        double sqrt = Math.sqrt(length);

        // Calculate number of rows and columns
        int rows = (int) Math.floor(sqrt);
        int columns = (int) Math.ceil(sqrt);

        // Increase number of rows if product of rows and columns is less than length
        if ((rows * columns) < length) {
            rows++;
        }

        // Split string into grid
        String[] grid = noSpaces.split("(?<=\\G.{" + columns + "})");
        StringBuilder sb = new StringBuilder();

        // Add i item of each column into new string
        for (int i = 0; i <= columns; i++) {
            for (String str : grid) {
                if (str.length() > i) {
                    sb.append(str.charAt(i));
                }
            }
        }

        String[] encryptedGrid = new String[columns];
        for (int i = 0; i < columns; i++) {
            StringBuilder sbNew = new StringBuilder();
            for (String str : grid) {
                if (str.length() > i) {
                    sbNew.append(str.charAt(i));
                }
            }
            encryptedGrid[i] = sbNew.toString();
        }

        String encryptedString = String.join(" ", encryptedGrid);
        return encryptedString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String s = bufferedReader.readLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
