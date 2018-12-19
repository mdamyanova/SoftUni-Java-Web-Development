import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {

    public static void main(String[] args) {
        String path = "D:\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int _byte = fileStream.read();
            while (_byte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(_byte));
                _byte = fileStream.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}