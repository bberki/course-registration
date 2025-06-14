import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CourseManager.loadCoursesFromFile("courses.txt");
            new RoleSelectionFrame().setVisible(true);
        });
    }
}
