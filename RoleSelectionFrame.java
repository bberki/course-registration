import javax.swing.*;
import java.awt.*;

public class RoleSelectionFrame extends JFrame {
    public RoleSelectionFrame() {
        setTitle("JAVACS Rol Seçimi");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton studentButton = new JButton("Öğrenci");
        JButton adminButton = new JButton("Yönetici");

        studentButton.addActionListener(e -> openPanel(new StudentPanel(), "Öğrenci Paneli"));
        adminButton.addActionListener(e -> openPanel(new AdminPanel(), "Yönetici Paneli"));

        JPanel panel = new JPanel();
        panel.add(studentButton);
        panel.add(adminButton);

        add(panel, BorderLayout.CENTER);
    }

    private void openPanel(JPanel panel, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(this);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Ders listesini bir kez yükleyelim
            CourseManager.loadCoursesFromFile("courses.txt");
            new RoleSelectionFrame().setVisible(true);
        });
    }
}
