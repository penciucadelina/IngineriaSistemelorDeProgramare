package edu.tucn.isp.ex1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Radu Miron
 */
public class Exercise1 {
    public static void main(String[] args) {
        TestManager testManager = new TestManagerImpl();
        CliUserInterface cliUserInterface = new CliUserInterface(testManager);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is 2+2?", new String[]{"3", "4", "5"}, new int[]{1}));
        questions.add(new Question("What is the capital of France?", new String[]{"London", "Paris", "Rome"}, new int[]{1}));
        cliUserInterface.addTestWithQuestions("Math and Geography Quiz", questions);

        List<TakenTest> testeeResults = cliUserInterface.findTesteeResultsWithLambda("Test1", takenTest -> takenTest.testName().equals("Math and Geography Quiz"));
        System.out.println("Testee Results: " + testeeResults);
    }
}



