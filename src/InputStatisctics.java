import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class InputStatisctics {
    InputStream fin;
    Statistics dictionary;

    public InputStatisctics(String inputFile, Statistics dict) throws FileNotFoundException {
        fin = new FileInputStream(inputFile);
        dictionary = dict;
    }

    public void inputData() {
        Scanner scan = new Scanner(fin, "UTF-8");
        scan.useDelimiter("[^a-zA-Zа-яА-Я0-9]");

        while (scan.hasNext()) {
            dictionary.addWord(scan.next());
        }

        scan.close();
    }
}
