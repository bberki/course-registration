import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private DefaultListModel<Course> courseModel = new DefaultListModel<>();
    private JList<Course> courseList;

    public AdminPanel() {
        setLayout(new BorderLayout());

        courseModel = new DefaultListModel<>();
        refreshCourses();
        courseList = new JList<>(courseModel);
        add(new JScrollPane(courseList), BorderLayout.CENTER);

        JTextField codeField = new JTextField(6);
        JTextField nameField = new JTextField(10);
        JTextField creditField = new JTextField(3);
        JCheckBox openBox = new JCheckBox("Açık");
        JButton addBtn = new JButton("Ekle");
        JButton removeBtn = new JButton("Seçiliyi Sil");

        addBtn.addActionListener(e -> {
            try {
                String code = codeField.getText();
                String name = nameField.getText();
                int credit = Integer.parseInt(creditField.getText());
                boolean open = openBox.isSelected();
                Course newCourse = new Course(code, name, credit, open);
                CourseManager.addCourse(newCourse);
                refreshCourses();
                JOptionPane.showMessageDialog(this, "Ders eklendi.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        removeBtn.addActionListener(e -> {
            Course selected = courseList.getSelectedValue();
            if (selected == null) return;
            try {
                CourseManager.removeCourse(selected.getCode());
                refreshCourses();
                JOptionPane.showMessageDialog(this, "Ders silindi.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        JPanel input = new JPanel();
        input.add(new JLabel("Kod:"));
        input.add(codeField);
        input.add(new JLabel("Ad:"));
        input.add(nameField);
        input.add(new JLabel("Kredi:"));
        input.add(creditField);
        input.add(openBox);
        input.add(addBtn);
        input.add(removeBtn);

        add(input, BorderLayout.SOUTH);
    }

    private void refreshCourses() {
        courseModel.clear();
        for (Course c : CourseManager.getCourseList()) {
            courseModel.addElement(c);
        }
    }
}
