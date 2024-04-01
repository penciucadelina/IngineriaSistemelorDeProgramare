package edu.tucn.isp.ex1;

import java.util.List;
import java.util.function.Predicate;

public class CliUserInterface {
    private TestManager testManager;

    public CliUserInterface(TestManager testManager) {
        this.testManager = testManager;
    }

    public void addTest(Test test) {
        testManager.addTest(test);
    }

    public void addTestWithQuestions(String testName, List<Question> questions) {
        Test test = new Test(testName, questions);
        testManager.addTest(test);
    }

    public void takeTest(Testee testee) {
        // Selectează un test aleatoriu
        Test randomTest = testManager.selectRandomTest();

        System.out.println("Please enter your name: ");
        String testeeName = System.console().readLine();
        testee.setName(testeeName);

        for (Question question : randomTest.questions()) {
            //System.out.println(question.getQuestion());
        }
        testManager.addTakenTest(new TakenTest(randomTest.testName(), testeeName, randomTest.questions().size(), 0));
    }

    public List<TakenTest> findResultsForTestee(String testeeName) {
        return testManager.findTesteeResults(testeeName);
    }

    public List<TakenTest> findTesteeResultsWithLambda(String testeeName, Predicate<TakenTest> filter) {
        List<TakenTest> allResults = testManager.findTesteeResults(testeeName);
        return allResults.stream().filter(filter).toList();
    }
}



