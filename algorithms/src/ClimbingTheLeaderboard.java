// Neil Khatri
// HackerRank – Climbing the Leaderboard
// Attempted 15/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClimbingTheLeaderboard {
    static List<Integer> climbingLeaderboard(List<Integer> ranked,
            List<Integer> player) {
        // Remove duplicates from ranked list because of dense ranking
        List<Integer> rankedUnique = ranked.stream()
                .distinct()
                .collect(toList());

        List<Integer> playerRanks = new ArrayList<>();

        /* Variable to set starting position to next possible list item as
           lists are sorted */
        int position = rankedUnique.size() - 1;

        for (int i = (player.size() - 1); i >= 0; i--) {
            // boolean variable to check that score has been allocated in rankings
            boolean isRanked = false;

            for (int j = position; j < rankedUnique.size(); j++) {
                if (player.get(i) >= rankedUnique.get(j)) {
                    playerRanks.add(j + 1);
                    position = j;
                    isRanked = true;
                    break;
                }
            }

            /*
                If score has not been ranked yet, it means it is at the bottom
                of the leaderboard
            */
            if (!isRanked) {
                playerRanks.add(rankedUnique.size() + 1);
            }
        }

        playerRanks.sort(Comparator.reverseOrder());
        return playerRanks;
    }

    private static int binarySearch(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr.get(mid) == key) {
                return mid;
            } else if (arr.get(mid) < key && key < arr.get(mid - 1)) {
                return mid;
            } else if (arr.get(mid) > key && key >= arr.get(mid + 1)) {
                return mid + 1;
            } else if (arr.get(mid) < key) {
                high = mid - 1;
            } else if (arr.get(mid) > key) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.flush();

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
