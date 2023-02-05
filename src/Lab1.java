public class Lab1 {
    public static void main(String[] args) {

        Statistics wordsInFile = new Statistics();

        InputStatistics input = new InputStatistics(args[0], wordsInFile);
        input.inputData();

        OutputStatistics output = new OutputStatistics(args.length == 1 ? "out.csv" : args[1], wordsInFile);
        output.outputData();

    }
}
