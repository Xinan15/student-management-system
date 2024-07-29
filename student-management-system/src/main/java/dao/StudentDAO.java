package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    // DAO 的意思是 Data Access Object，是一个面向对象的数据库接口
    // 在 DAO 文件夹中创建的是 `数据访问对象`，用于代码中对数据库的 `增删改查` 操作

    // 在最佳实践中，DAO 层应该是一个 `接口`，用于描述项目应该实现哪些具体的 `增删改查` 操作
    // 然后在 DAO 文件夹中创建一个 `实现类`，用于实现接口中的方法

    void addStudent(Student student);   // `增` - 添加学生

    Student getStudentById(int studentId); // `查` - 通过学号获取单个学生

    List<Student> getAllStudents();     // `查` - 获取所有学生

    void updateStudent(Student student); // `改` - 更新学生信息

    void deleteStudent(int studentId);   // `删` - 删除学生
}