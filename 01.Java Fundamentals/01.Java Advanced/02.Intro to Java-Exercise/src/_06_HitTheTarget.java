import java.util.Scanner;

public class _06_HitTheTarget {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int k = 1; k <= 20; k++) {
                if (i + k == num) {
                    System.out.printf("%d + %d = %d\n",
                            i, k, num);
                } else if (i - k == num) {
                    System.out.printf("%d - %d = %d\n",
                            i, k, num);
                }
            }
        }
    }
}