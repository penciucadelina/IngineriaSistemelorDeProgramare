package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

class GradeSystem {
    private List<Student> students;

    public GradeSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void updateStudent(int index, Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        } else {
            System.out.println("Invalid.");
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}

