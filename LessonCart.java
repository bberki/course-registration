import java.util.*;

public class LessonCart<T extends Course> {
    private List<T> cart = new ArrayList<>();
    private boolean saved = false;

    public void addCourse(T course) {
        int totalCredits = cart.stream().mapToInt(Course::getCredit).sum();
        if (cart.contains(course)) {
            System.out.println("Bu ders zaten sepette mevcut.");
        } else if (totalCredits + course.getCredit() > 30) {
            System.out.println("Toplam kredi limiti aşılıyor! Maksimum 30 kredi alabilirsiniz.");
        } else {
            cart.add(course);
            System.out.println("Ders sepete eklendi: " + course.getCode());
        }
    }

    /**
     * Adds the given course and returns the status message instead of printing
     * to the console. The logic is identical to {@link #addCourse(Course)} but
     * allows GUI components to show feedback easily.
     */
    public String addCourseWithMessage(T course) {
        int totalCredits = cart.stream().mapToInt(Course::getCredit).sum();
        if (cart.contains(course)) {
            return "Bu ders zaten sepette mevcut.";
        } else if (totalCredits + course.getCredit() > 30) {
            return "Toplam kredi limiti aşılıyor! Maksimum 30 kredi alabilirsiniz.";
        } else {
            cart.add(course);
            return "Ders sepete eklendi: " + course.getCode();
        }
    }

    public void removeCourseByCode(String code) {
        if (saved) {
            System.out.println("Sepet kaydedildiği için ders çıkarılamaz.");
            return;
        }
        Optional<T> toRemove = cart.stream()
                                   .filter(c -> c.getCode().equalsIgnoreCase(code))
                                   .findFirst();
        if (toRemove.isPresent()) {
            cart.remove(toRemove.get());
            System.out.println("Ders sepetten çıkarıldı: " + code);
        } else {
            System.out.println("Bu ders sepette bulunamadı.");
        }
    }

    /**
     * Removes the course with the given code and returns a message describing
     * the result. This is useful for GUI feedback.
     */
    public String removeCourseByCodeWithMessage(String code) {
        if (saved) {
            return "Sepet kaydedildiği için ders çıkarılamaz.";
        }
        Optional<T> toRemove = cart.stream()
                                   .filter(c -> c.getCode().equalsIgnoreCase(code))
                                   .findFirst();
        if (toRemove.isPresent()) {
            cart.remove(toRemove.get());
            return "Ders sepetten çıkarıldı: " + code;
        } else {
            return "Bu ders sepette bulunamadı.";
        }
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Sepetiniz boş.");
        } else {
            System.out.println("=== Ders Sepetiniz ===");
            for (T course : cart) {
                System.out.println(course);
            }
        }
    }

    public void saveCart() {
        saved = true;
        System.out.println("Sepet başarıyla kaydedildi.");
    }

    /**
     * Marks the cart as saved and returns a user-friendly message. If the cart
     * is already saved, an information message is returned instead.
     */
    public String saveCartWithMessage() {
        if (saved) {
            return "Sepet zaten kaydedildi.";
        }
        saved = true;
        return "Sepet başarıyla kaydedildi.";
    }

    public boolean isSaved() {
        return saved;
    }

    /**
     * Returns an unmodifiable view of the courses currently in the cart.
     */
    public List<T> getCourses() {
        return Collections.unmodifiableList(cart);
    }
}
