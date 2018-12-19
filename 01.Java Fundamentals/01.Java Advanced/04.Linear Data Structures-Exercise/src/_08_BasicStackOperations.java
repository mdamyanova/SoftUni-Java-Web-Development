import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.contains(x)) {
            System.out.println(true);
        } else {
            int min = Integer.MAX_VALUE;
            for (int num: stack) {
                if (num < min) {
                    min = num;
                }
            }

            if (min == Integer.MAX_VALUE) {
                min = 0;
            }
            System.out.println(min);
        }
    }
}