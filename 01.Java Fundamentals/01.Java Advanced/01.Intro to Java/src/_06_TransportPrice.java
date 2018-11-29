import java.util.Scanner;

public class _06_TransportPrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int km = Integer.parseInt(scanner.nextLine());
        String dayNight = scanner.nextLine();
        double taxiRate = 0.90;

        if (dayNight.equals("day")) {
            taxiRate = 0.79;
        }

        if (km < 20)
            System.out.printf("%.2f", 0.70 + (km * taxiRate));
        else if (km < 100)
            System.out.printf("%.2f", km * 0.09);
        else
            System.out.printf("%.2f", km * 0.06);
    }
}