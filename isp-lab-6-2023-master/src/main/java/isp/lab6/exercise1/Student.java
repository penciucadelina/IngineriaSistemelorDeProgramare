package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    private String name;
    private int id;
    private HashMap<String, Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public void updateGrade(String subject, int grade) {
        if (grades.containsKey(subject)) {
            grades.put(subject, grade);
        } else {
            System.out.println("Not found.");
        }
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int total = 0;
        for (int grade : grades.values()) {
            total += grade;
        }
        return (double) total / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grades=" + grades +
                '}';
    }
}