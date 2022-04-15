// Neil Khatri
// HackerRank – Electronics Shop
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/electronics-shop/problem

import java.io.*;
import java.util.*;

public class ElectronicsShop {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxPrice = 0;

        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int totalPrice = keyboard + drive;
                if (totalPrice > maxPrice && totalPrice <= b) {
                    maxPrice = totalPrice;
                }
            }
        }

        return (maxPrice != 0) ? maxPrice : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    static void skip() {
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        String[] bnm = scanner.nextLine().split(" ");
        skip();

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        skip();

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        skip();

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
