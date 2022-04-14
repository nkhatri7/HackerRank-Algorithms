import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// Neil Khatri
// HackerRank – Grading Students (Implementation)
// Attempted 14/04/2022

// CHALLENGE LINK: https://www.hackerrank.com/challenges/grading/problem

public class GradingStudents {
    private static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade: grades) {
            if (grade >= 38 && grade % 5 >= 3) {
                int roundedGrade = grade + (5 - (grade % 5));
                roundedGrades.add(roundedGrade);
            } else {
                roundedGrades.add(grade);
            }
        }

        return roundedGrades;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gradesCount = Integer.parseInt(scanner.nextLine());

        List<Integer> grades = IntStream.range(0, gradesCount)
            .mapToObj(i -> scanner.nextLine())
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = gradingStudents(grades);
        System.out.println(
                result.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                + "\n"
        );
    }
}
