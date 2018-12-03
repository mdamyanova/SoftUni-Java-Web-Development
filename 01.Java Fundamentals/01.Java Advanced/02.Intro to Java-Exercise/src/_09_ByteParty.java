import java.util.Scanner;

public class _09_ByteParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        while (true) {
            String[] command = scanner.nextLine().split(" ");

            if (command[0].equals("party")) {
                for (int num : numbers) {
                    System.out.println(num);
                }
                break;
            }

            int action = Integer.parseInt(command[0]);
            int position = Integer.parseInt(command[1]);

            switch (action) {
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = (numbers[i] ^ (1 << position));
                    }
                    break;
                case 0:
                    int mask = ~(1 << position);
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask;
                    }
                    break;
                case 1:
                    int mask1 = 1 << position;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask1;
                    }
                    break;
            }
        }
    }
}