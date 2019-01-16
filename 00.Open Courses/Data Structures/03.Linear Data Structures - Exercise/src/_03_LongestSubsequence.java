import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_LongestSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCount = 1;
        int value = numbers.get(0);
        int currentCount = 1;

        for (int i = 1; i < numbers.size(); i++) {

            int currentNumber = numbers.get(i);
            int prevNumber = numbers.get(i - 1);

            if (currentNumber == prevNumber) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    value = currentNumber;
                }
            } else {
                currentCount = 1;
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(value + " ");
        }
    }
}