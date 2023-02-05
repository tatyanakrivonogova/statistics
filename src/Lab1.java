import java.io.IOException;

public class Lab1 {
    public static void main(String[] args) throws IOException {

        Statistics wordsInFile = new Statistics();

        InputStatistics input = new InputStatistics(args[0], wordsInFile);
        input.inputData();

        OutputStatistics output = new OutputStatistics(args[1], wordsInFile);
        output.outputData();

    }
}
