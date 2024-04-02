package isp.lab6.exercise1;

import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        GradeSystem system = new GradeSystem();

        system.addStudent(new Student("Ion", 1));
        system.addStudent(new Student("Elena", 2));
        system.addStudent(new Student("Maria", 3));

        List<Student> students = system.getStudents();
        System.out.println("Lista de studenti:");
        for (Student student : students) {
            System.out.println("Nume: " + student.getName() + ", ID: " + student.getId());
        }

        if (!students.isEmpty()) {
            Student studentToRemove = students.get(1);
            system.removeStudent(studentToRemove);
            System.out.println("Studentul " + studentToRemove.getName() + " a fost sters.");
        } else {
            System.out.println("Nu exista studenti de sters.");
        }


        for (Student student : students) {
            student.addGrade("Matematica", 85);
            student.addGrade("Fizica", 90);
        }


        System.out.println("Media fiecarui student:");
        for (Student student : students) {
            double studentAverage = student.calculateAverageGrade();
            System.out.println("Student: " + student.getName() + ", Media: " + studentAverage);
        }


        Student student = new Student("Test", 1);
        student.addGrade("Fizica", 30);
        student.updateGrade("Fizica", 95);

        System.out.println(student);
    }
}