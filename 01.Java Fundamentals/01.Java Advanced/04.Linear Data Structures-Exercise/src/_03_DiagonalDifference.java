import java.util.Scanner;

public class _03_DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimensions][dimensions];

        for (int row = 0; row < dimensions; row++) {
            String[] line = scanner.nextLine().split(" ");

            for (int col = 0; col < dimensions; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int primarySum = 0;
        for (int i = 0; i < dimensions; i++) {
            primarySum += matrix[i][i];
        }

        int secondarySum = 0;
        for (int i = 0; i < dimensions; i++) {
            for (int col = dimensions - 1 - i; col >= 0; col--) {
                secondarySum += matrix[i][col];
                i++;
            }
        }

        System.out.println(Math.abs(primarySum - secondarySum));
    }
}