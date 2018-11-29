import java.math.BigDecimal;
import java.util.Scanner;

public class _04_EuroTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantity = scanner.nextDouble();
        double pricePerKg = 1.20;
        BigDecimal priceInLv = new BigDecimal(pricePerKg * quantity);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal marks = exchangeRate.multiply(priceInLv);
        System.out.printf("%.2f marks", marks);
    }
}