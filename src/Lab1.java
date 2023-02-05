import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab1 {
    public static void main(String[] args) throws IOException {

        Statistics wordsInFile = new Statistics();

        InputStatisctics input = new InputStatisctics(args[0], wordsInFile);
        input.inputData();

        OutputStatistics output = new OutputStatistics(args[1], wordsInFile);
        output.outputData();

//        wordsInFile.addWord("hello");
//        wordsInFile.addWord("world");
//        wordsInFile.addWord("hello");

    }
}
