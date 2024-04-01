package edu.tucn.isp.ex1;


import java.util.List;

interface TestManager {
    Test selectRandomTest();

    void addTakenTest(TakenTest tknTest);

    List<TakenTest> findTesteeResults(String testeeName);

    void addTest(Test test);
}