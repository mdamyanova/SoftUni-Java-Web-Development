import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_WriteToFile {

    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)) {
            int _byte = 0;
            while ((_byte = inputStream.read()) >= 0) {
                if (!symbols.contains((char)_byte)) {
                    outputStream.write(_byte);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}