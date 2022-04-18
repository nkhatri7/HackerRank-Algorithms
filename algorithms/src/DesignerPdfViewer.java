// Neil Khatri
// HackerRank – Designer PDF Viewer
// Attempted 18/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class DesignerPdfViewer {
    static int designerPdfViewer(List<Integer> h, String word) {
        int length = word.length();
        int max = 0;

        for (int i = 0; i < length; i++) {
            char tempChar = word.charAt(i);
            max = (max < h.get(tempChar - 97)) ? h.get(tempChar - 97) : max;
        }

        return length * max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        List<Integer> h = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
