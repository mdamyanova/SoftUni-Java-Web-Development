import java.util.Arrays;
import java.util.Scanner;

public class _01_SumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Arrays.stream(numbers).sum();
        double average = sum / numbers.length;

        System.out.printf("Sum=%d; Average=%.2f", sum, average);
    }
}