import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _05_CountOfOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer, Integer> occurrences = new TreeMap<>();

        Arrays
                .stream(numbers)
                .forEach(i -> {
                    occurrences.putIfAbsent(i, 0);
                    occurrences.put(i, occurrences.get(i) + 1);
        });

        occurrences.forEach((a, b) -> System.out.println(a + " -> " + b + " times"));
    }
}