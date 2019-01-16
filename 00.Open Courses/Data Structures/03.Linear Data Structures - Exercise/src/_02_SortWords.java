import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _02_SortWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.asList(scanner.nextLine().split("\\s+"));

        Collections.sort(words);

        System.out.println(String.join(" ", words));
    }
}