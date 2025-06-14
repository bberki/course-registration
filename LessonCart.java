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

    public boolean isSaved() {
        return saved;
    }
}
