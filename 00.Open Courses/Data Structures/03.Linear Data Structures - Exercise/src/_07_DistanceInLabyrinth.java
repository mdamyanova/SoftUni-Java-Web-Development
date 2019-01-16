import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _07_DistanceInLabyrinth {
    private static String[][] labyrinth;
    private static int size;
    private static int row;
    private static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());
        labyrinth = new String[size][size];
        fillLabyrinth(scanner);
        markSteps();
        printLabyrinth();
    }

    private static void fillLabyrinth(Scanner reader) {
        for (int i = 0; i < size; i++) {
            String input = reader.nextLine();

            for (int j = 0; j < input.length(); j++) {
                String currentChar = Character.toString(input.charAt(j));
                labyrinth[i][j] = currentChar;

                if (currentChar.equals("*")) {
                    row = i;
                    col = j;
                }
            }
        }
    }

    private static void markSteps() {
        Deque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(row, col, 0));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            if (cell.getRow() > 0 && labyrinth[cell.getRow() - 1][cell.getCol()].equals("0")) {
                queue.offer(new Cell(cell.getRow() - 1, cell.getCol(), cell.getStep() + 1));
                labyrinth[cell.getRow() - 1][cell.getCol()] = Integer.toString(cell.getStep() + 1);
            }

            if (cell.getCol() < labyrinth[0].length - 1 && labyrinth[cell.getRow()][cell.getCol() + 1].equals("0")) {
                queue.offer(new Cell(cell.getRow(), cell.getCol() + 1, cell.getStep() + 1));
                labyrinth[cell.getRow()][cell.getCol() + 1] = Integer.toString(cell.getStep() + 1);
            }

            if (cell.getRow() < labyrinth[0].length - 1 && labyrinth[cell.getRow() + 1][cell.getCol()].equals("0")) {
                queue.offer(new Cell(cell.getRow() + 1, cell.getCol(), cell.getStep() + 1));
                labyrinth[cell.getRow() + 1][cell.getCol()] = Integer.toString(cell.getStep() + 1);
            }

            if (cell.getCol() > 0 && labyrinth[cell.getRow()][cell.getCol() - 1].equals("0")) {
                queue.offer(new Cell(cell.getRow(), cell.getCol() - 1, cell.getStep() + 1));
                labyrinth[cell.getRow()][cell.getCol() - 1] = Integer.toString(cell.getStep() + 1);
            }
        }
    }

    private static void printLabyrinth() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String currentElement = labyrinth[i][j];

                if (currentElement.equals("0")) {
                    currentElement = "u";
                }

                System.out.print(currentElement);
            }

            System.out.println();
        }
    }

    public static class Cell {

        private int row;
        private int col;
        private int step;

        public Cell(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getStep() {
            return step;
        }
    }
}