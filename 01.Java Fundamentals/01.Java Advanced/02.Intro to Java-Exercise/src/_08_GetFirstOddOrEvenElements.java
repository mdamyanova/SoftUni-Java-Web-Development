import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _08_GetFirstOddOrEvenElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String[] line = scanner.nextLine().split(" ");

        getFirstOddOrEvenElements(input, Integer.parseInt(line[1]), line[2]);
    }

    private static void getFirstOddOrEvenElements(String[] input, int maxCount, String oddOrEven) {
        int counter = 0;
        List<String> result = new ArrayList<>();
        for (String num : input) {
            if (counter >= maxCount) {
                break;
            }
            if (checkOddOrEven(num, oddOrEven)) {
                result.add(num);
                counter++;
            }
        }
        System.out.println(String.join(" ", result));
    }

    private static boolean checkOddOrEven(String number, String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return Integer.parseInt(number) % 2 != 0;
        } else {
            return Integer.parseInt(number) % 2 == 0;
        }
    }
}