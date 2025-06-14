import java.util.*;

public class CourseManager {
    private static List<Course> courseList = new ArrayList<>();
    private static boolean saved = false; // Ders sepeti kaydedildi mi kontrolü için (örnek)

    // Tüm dersleri göster
    public static void showAllCourses() {
        if (courseList.isEmpty()) {
            System.out.println("Ders listesi boş.");
            return;
        }
        System.out.println("=== Tüm Dersler ===");
        for (Course c : courseList) {
            System.out.println(c);
        }
    }

    // Ders ekleme (yönetici için)
    public static void addCourse(Course course) throws Exception {
        if (courseList.contains(course)) {
            throw new Exception("Bu ders zaten listede mevcut: " + course.getCode());
        }
        courseList.add(course);
        saved = false; // Yeni ders eklendi, henüz kayıt yok
        System.out.println("Ders başarıyla eklendi: " + course.getCode());
    }

    // Ders silme (yönetici için)
    public static void removeCourse(String courseCode) throws Exception {
        Course course = findCourse(courseCode);
        if (course == null) {
            throw new Exception("Silmek istediğiniz ders bulunamadı: " + courseCode);
        }
        courseList.remove(course);
        saved = false; // Ders silindi, henüz kayıt yok
        System.out.println("Ders başarıyla silindi: " + courseCode);
    }

    // Ders koduna göre bulma
    public static Course findCourse(String courseCode) {
        for (Course c : courseList) {
            if (c.getCode().equalsIgnoreCase(courseCode)) {
                return c;
            }
        }
        return null;
    }

    // Kaydedilmiş mi kontrolü
    public static boolean isSaved() {
        return saved;
    }

    // Kaydetme işlemi (örnek, burada sadece flag değiştiriyoruz)
    public static void saveCart() {
        saved = true;
        System.out.println("Ders sepeti kaydedildi.");
    }

    // Ders listesine erişim (isteğe bağlı)
    public static List<Course> getCourseList() {
        return courseList;
    }
}
