import java.math.BigInteger;
import java.util.Scanner;

public class _08_ProductOfNumbersNM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger product = BigInteger.ONE;
        int tempN = n;

        do {
            BigInteger num = new BigInteger("" + tempN);
            product = product.multiply(num);
            tempN++;
        } while (tempN <= m);

        System.out.printf("product[%d..%d] = %d\n", n, m, product);
    }
}