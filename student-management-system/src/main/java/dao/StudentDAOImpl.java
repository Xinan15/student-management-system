package dao;

import model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 本 class 是对 StudentDAO 接口的实现
public class StudentDAOImpl implements StudentDAO {

    // 暂时不链接数据库，使用一个 List 来存储数据

    private List<Student> students = new ArrayList<>();

    @Override
    // @Override 是一个注解，用于标记该方法是对接口中的方法的重写/实现
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;    // 如果没有找到对应的学生，返回 null
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
        // 这里是一个好的实践，将 students 引用的 List 创建成一个新的 ArrayList，这样可以避免外部对 students 的修改
    }

    @Override
    public void updateStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                s.setName(student.getName());
                s.setAge(student.getAge());
                s.setContactNumber(student.getContactNumber());
                s.setMajor(student.getMajor());
                break;
                // 这里使用了一个 `break` 语句，用于跳出循环，避免继续遍历
            }
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == studentId) {
                iterator.remove();
                break; // 假设 ID 是唯一的，找到后就可以结束循环
            }
        }
    }
}