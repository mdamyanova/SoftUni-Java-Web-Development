import java.util.Scanner;

public class _07_CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstStr = scanner.next();
        String secondStr = scanner.next();
        int shortestLen = Math.min(firstStr.length(),
                secondStr.length());
        int sum = 0;

        for (int i = 0; i < shortestLen; i++) {
            sum += firstStr.charAt(i) * secondStr.charAt(i);
        }

        int longestLen = Math.max(firstStr.length(), secondStr.length());
        String restElements = firstStr;

        if (longestLen == secondStr.length()) {
            restElements = secondStr;
        }

        for (int i = longestLen - 1; i >= shortestLen; i--) {
            sum += restElements.charAt(i);
        }

        System.out.println(sum);
    }
}