import java.util.Scanner;

public class _01_FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(line[0]);
        String pattern = line[1];
        int[][] matrix = new int[dimensions][dimensions];

        if (pattern.equals("A")) {
            fillPatternA(matrix, dimensions);
        } else if (pattern.equals("B")) {
            fillPatternB(matrix, dimensions);
        }
    }

    private static void fillPatternA(int[][] matrix, int dimensions) {
        int startNumber = 1;
        for (int col = 0; col < dimensions; col++) {
            for (int row = 0; row < dimensions; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }

        printMatrix(matrix);
    }

    private static void fillPatternB(int[][] matrix, int dimensions) {
        int startNumber = 1;
        for (int col = 0; col < dimensions; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dimensions; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = dimensions - 1; row >= 0; row--)
                {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}