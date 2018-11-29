import java.util.Scanner;

public class _03_FormattingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        String binaryA = Integer.toBinaryString(a);
        StringBuilder colTwo = new StringBuilder();

        if (binaryA.length() >= 10) {
            colTwo.append(binaryA);
            colTwo.setLength(10);
        } else {
            int size = 10 - binaryA.length();
            String fill = new String(new char[size])
                    .replace("\0", "0");
            colTwo.append(fill);
            colTwo.append(binaryA);
        }

        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|",
                a, colTwo, b, c);
    }
}