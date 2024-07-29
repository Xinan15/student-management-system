package ui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.util.List;  // 添加这行导入

public class StudentManagementUI {

    // UI 层是 `用户界面层`，用于处理用户界面的显示、用户输入等
    // 在 UI 层中，可以调用 Service 层的方法，实现对数据库的操作

    private StudentService studentService;

    public StudentManagementUI(StudentService studentService) {
        this.studentService = studentService;
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField majorField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Contact:"));
        panel.add(contactField);
        panel.add(new JLabel("Major:"));
        panel.add(majorField);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());
                int age = Integer.parseInt(ageField.getText());
                String contact = contactField.getText();
                String major = majorField.getText();
                studentService.addStudent(name, id, age, contact, major);
                JOptionPane.showMessageDialog(frame, "Student added successfully!");
                // 清空输入字段
                nameField.setText("");
                idField.setText("");
                ageField.setText("");
                contactField.setText("");
                majorField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input for ID or Age. Please enter numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(addButton);

        JButton showAllButton = new JButton("Show All Students");
        showAllButton.addActionListener(e -> {
            List<Student> allStudents = studentService.getAllStudents();
            StringBuilder message = new StringBuilder();
            for (Student s : allStudents) {
                message.append(s.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, message.toString());
        });

        panel.add(showAllButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}