import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_RemoveOddOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer num : numbers) {
            int count = 0;

            for (Integer number : numbers) {
                if (num.equals(number)) {
                    count++;
                }
            }

            if (count % 2 == 0) {
                System.out.print(num + " ");
            }
        }
    }
}