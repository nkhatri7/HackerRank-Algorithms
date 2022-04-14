// Neil Khatri
// HackerRank – Number Line Jumps (Implementation)
// Attempted 14/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/kangaroo/problem

import java.io.*;

public class NumberLineJumps {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // x1 is always behind x2 so v1 has to be more than v2 for kangaroos to meet
        boolean canCatchUp = (v1 > v2);
        boolean willIntersect = false;
        if (canCatchUp) {
            willIntersect = (x1 - x2) % (v2 - v1) == 0;
        }

        return (willIntersect) ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
