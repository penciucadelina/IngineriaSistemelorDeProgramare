package edu.tucn.isp.ex1;

public class Testee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeTest(TestManager testManager) {
        Test randomTest = testManager.selectRandomTest();
    }
}