import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for (String num : input) {
            stack.push(Integer.parseInt(num));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}