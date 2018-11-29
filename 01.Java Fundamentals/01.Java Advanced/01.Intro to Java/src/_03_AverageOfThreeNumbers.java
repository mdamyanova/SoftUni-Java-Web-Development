import java.util.Scanner;

public class _03_AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        System.out.printf("%.2f",
                (firstNum + secondNum + thirdNum) / 3);
    }
}