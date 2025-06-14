import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {
    private LessonCart<Course> cart = new LessonCart<>();
    private DefaultListModel<Course> courseModel = new DefaultListModel<>();
    private DefaultListModel<Course> cartModel = new DefaultListModel<>();
    private JList<Course> courseList;
    private JList<Course> cartList;

    public StudentPanel() {
        setLayout(new BorderLayout());

        for (Course c : CourseManager.getCourseList()) {
            courseModel.addElement(c);
        }

        courseList = new JList<>(courseModel);
        cartList = new JList<>(cartModel);

        JPanel lists = new JPanel(new GridLayout(1, 2));
        lists.add(new JScrollPane(courseList));
        lists.add(new JScrollPane(cartList));
        add(lists, BorderLayout.CENTER);

        JButton addBtn = new JButton("Ekle");
        JButton removeBtn = new JButton("Çıkar");
        JButton saveBtn = new JButton("Kaydet");

        addBtn.addActionListener(e -> addSelectedCourse());
        removeBtn.addActionListener(e -> removeSelectedCourse());
        saveBtn.addActionListener(e -> saveCart());

        JPanel buttons = new JPanel();
        buttons.add(addBtn);
        buttons.add(removeBtn);
        buttons.add(saveBtn);
        add(buttons, BorderLayout.SOUTH);
    }

    private void addSelectedCourse() {
        Course selected = courseList.getSelectedValue();
        if (selected == null) return;
        if (cart.isSaved()) {
            JOptionPane.showMessageDialog(this, "Sepet zaten kaydedildi, ders eklenemez.");
            return;
        }
        if (!selected.isOpen()) {
            JOptionPane.showMessageDialog(this, "Bu ders şu anda kapalı.");
            return;
        }
        String msg = cart.addCourseWithMessage(selected);
        refreshCart();
        JOptionPane.showMessageDialog(this, msg);
    }

    private void removeSelectedCourse() {
        Course selected = cartList.getSelectedValue();
        if (selected == null) return;
        String msg = cart.removeCourseByCodeWithMessage(selected.getCode());
        refreshCart();
        JOptionPane.showMessageDialog(this, msg);
    }

    private void saveCart() {
        String msg = cart.saveCartWithMessage();
        JOptionPane.showMessageDialog(this, msg);
    }

    private void refreshCart() {
        cartModel.clear();
        for (Course c : cart.getCourses()) {
            cartModel.addElement(c);
        }
    }
}
