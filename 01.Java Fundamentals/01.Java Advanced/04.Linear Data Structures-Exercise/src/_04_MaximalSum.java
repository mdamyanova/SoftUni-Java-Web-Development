import java.util.Scanner;

public class _04_MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");

            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        printMatrixWithMaxSum(matrix);
    }

    private static void printMatrixWithMaxSum(int[][] matrix) {
        int bestSum = Integer.MIN_VALUE;
        int currSum = 0;
        int[][] matrixWithMaxSum = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                currSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row][col + 2] + matrix[row + 1][col] +
                        matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] +
                        matrix[row + 2][col + 2];

                if (currSum > bestSum) {
                    bestSum = currSum;

                    for (int i = 0; i < matrixWithMaxSum.length; i++) {
                        for (int j = 0; j < matrixWithMaxSum[i].length; j++) {
                            matrixWithMaxSum[i][j] = matrix[row + i][col + j];
                        }
                    }
                }
            }
        }

        System.out.println("Sum = " + bestSum);

        for (int row = 0; row < matrixWithMaxSum.length; row++) {
            for (int col = 0; col < matrixWithMaxSum[row].length; col++) {
                System.out.print(matrixWithMaxSum[row][col] + " ");
            }

            System.out.println();
        }
    }
}