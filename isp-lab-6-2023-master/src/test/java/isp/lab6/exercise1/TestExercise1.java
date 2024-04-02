package isp.lab6.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExercise1 {
    @Test
    public void testAddStudent() {
        GradeSystem system = new GradeSystem();
        int initialSize = system.getStudents().size();
        system.addStudent(new Student("Test", 1));
        int newSize = system.getStudents().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testRemoveStudent() {
        GradeSystem system = new GradeSystem();
        system.addStudent(new Student("Test", 1));
        int initialSize = system.getStudents().size();
        system.removeStudent(system.getStudents().get(0));
        int newSize = system.getStudents().size();
        assertEquals(initialSize - 1, newSize);
    }

    @Test
    public void testUpdateStudent() {
        GradeSystem system = new GradeSystem();
        Student student = new Student("Test", 1);
        system.addStudent(student);
        student.addGrade("Matematica", 90);
        student.updateGrade("Matematica", 95);
        assertEquals(95.0, student.calculateAverageGrade(), 0.001);
    }

    @Test
    public void testCalculateAverageGrade() {
        Student student = new Student("Test", 1);
        student.addGrade("Matematica", 80);
        student.addGrade("Fizica", 90);
        assertEquals(85.0, student.calculateAverageGrade(), 0.001);
    }
}