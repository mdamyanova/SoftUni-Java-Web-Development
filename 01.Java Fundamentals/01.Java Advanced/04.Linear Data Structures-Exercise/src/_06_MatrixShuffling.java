import java.util.Scanner;

public class _06_MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];
            }
        }

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("END")) {
            try {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine().split(" ");
        }
    }
}