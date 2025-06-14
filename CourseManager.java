import java.util.*;
import java.io.*;

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

    /**
     * Basit bir dosya okuma yardımcısı. "kod;ad;kredi;açık" formatındaki satırları
     * ders listesine ekler. Dosya bulunamazsa sessizce görmezden gelinir.
     */
    public static void loadCoursesFromFile(String path) {
        File file = new File(path);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 4) continue;
                String code = parts[0];
                String name = parts[1];
                int credit = Integer.parseInt(parts[2]);
                boolean open = Boolean.parseBoolean(parts[3]);
                Course c = new Course(code, name, credit, open);
                if (!courseList.contains(c)) {
                    courseList.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Ders dosyası okunamadı: " + e.getMessage());
        }
    }

    // Ders listesine erişim (isteğe bağlı)
    public static List<Course> getCourseList() {
        return courseList;
    }
}
