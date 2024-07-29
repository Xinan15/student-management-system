package model;

// 在 model 文件夹中创建的是 `业务模型`，用于代码中核心的 `数据实体类`
// 例如学生类 `Student`，包含学生的姓名、学号、年龄、联系方式、专业等属性。同时配置了对应的 getter 和 setter 方法

// 在 IntelliJ IDEA 中，可以在右键菜单中选择 `Generate` 自动生成 getter 和 setter 方法
// 同时在 IntelliJ IDEA 中，可以使用 `Option + Command + L` 快捷键格式化代码

public class Student {
    // 属性定义
    private String name;
    private int studentId;
    private int age;
    private String contactNumber;
    private String major;

    // 构造函数
    public Student(String name, int studentId, int age, String contactNumber, String major) {
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.contactNumber = contactNumber;
        this.major = major;
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // toString 方法，用于打印对象信息
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}