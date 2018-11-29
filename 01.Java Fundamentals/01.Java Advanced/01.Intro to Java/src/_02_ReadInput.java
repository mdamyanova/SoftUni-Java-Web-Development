import java.util.Scanner;

public class _02_ReadInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstStr = scanner.next();
        String secondStr = scanner.next();
        scanner.nextLine();
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();
        scanner.nextLine();
        String thirdStr = scanner.next();

        System.out.printf("%s %s %s %d",
                firstStr, secondStr, thirdStr,
                firstInt + secondInt + thirdInt);
    }
}