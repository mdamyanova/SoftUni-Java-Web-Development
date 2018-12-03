import java.util.*;

public class _01_EncryptSortPrintArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int sum = 0;

            for (int k = 0; k < name.length(); k++) {
                switch (name.toLowerCase().charAt(k)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        sum += name.charAt(k) * name.length();
                        break;
                    default:
                        sum += name.charAt(k) / name.length();
                }
            }

            result.add(sum);
        }

        Collections.sort(result);

        for (int num : result) {
            System.out.println(num);
        }
    }
}