import dao.StudentDAO;
import dao.StudentDAOImpl;
import service.StudentService;
import ui.StudentManagementUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentDAO studentDAO = new StudentDAOImpl();
            StudentService studentService = new StudentService(studentDAO);
            new StudentManagementUI(studentService);
        });
    }
}