package edu.tucn.isp.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TestManagerImpl implements TestManager {
    private List<Test> tests;
    private List<TakenTest> takenTests;

    public TestManagerImpl() {
        this.tests = new ArrayList<>();
        this.takenTests = new ArrayList<>();
    }

    @Override
    public Test selectRandomTest() {
        if (tests.isEmpty()) {
            throw new IllegalStateException("No tests available.");
        }
        Random random = new Random();
        return tests.get(random.nextInt(tests.size()));
    }

    @Override
    public void addTakenTest(TakenTest tknTest) {
        takenTests.add(tknTest);
    }

    @Override
    public List<TakenTest> findTesteeResults(String testeeName) {
        List<TakenTest> results = new ArrayList<>();
        for (TakenTest tknTest : takenTests) {
            if (tknTest.testeeName().equals(testeeName)) {
                results.add(tknTest);
            }
        }
        return results;
    }

    public void addTest(Test test) {
        tests.add(test);
    }
}