import java.util.Scanner;

public class _02_MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        char firstAndLast = 'a';
        char middle = 'a';
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                StringBuilder sb = new StringBuilder();
                sb.append((char)(row + 97));
                sb.append((char)(row + col + 97));
                sb.append((char)(row + 97));
                matrix[row][col] = sb.toString();
                middle++;

                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
            middle = ++firstAndLast;
        }
    }
}