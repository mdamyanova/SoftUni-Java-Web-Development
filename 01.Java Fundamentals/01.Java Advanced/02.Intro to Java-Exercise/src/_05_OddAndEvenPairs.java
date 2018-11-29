import java.util.Scanner;

public class _05_OddAndEvenPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");

        if (arr.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < arr.length; i+=2) {
                int firstNum = Integer.parseInt(arr[i]);
                int secondNum = Integer.parseInt(arr[i + 1]);
                String result = "different";
                if (firstNum % 2 == 0 && secondNum % 2 == 0) {
                    result = "both are even";
                } else if (firstNum % 2 != 0 && secondNum % 2 != 0) {
                    result = "both are odd";
                }

                System.out.printf("%d, %d -> %s\n",
                        firstNum, secondNum, result);
            }
        }
    }
}