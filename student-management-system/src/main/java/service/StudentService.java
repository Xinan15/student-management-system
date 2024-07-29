package service;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentService {

    // Service 层是 `业务逻辑层`，用于处理业务逻辑，例如对数据的处理、逻辑判断等
    // 在 Service 层中，可以调用 DAO 层的方法，实现对数据库的操作

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void addStudent(String name, int studentId, int age, String contactNumber, String major) {
        Student student = new Student(name, studentId, age, contactNumber, major);
        studentDAO.addStudent(student);
    }

    public Student getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}