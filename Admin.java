import java.util.Scanner;

public class Admin extends User {
    private Scanner scanner = new Scanner(System.in);

    public Admin(String name) {
        super(name);
    }

    @Override
    public void showMenu() {
        int choice = 0;
        do {
            System.out.println("\n=== Yönetici Menüsü ===");
            System.out.println("1. Yeni ders ekle");
            System.out.println("2. Ders sil");
            System.out.println("3. Tüm dersleri görüntüle");
            System.out.println("4. Çıkış ve rol seçimine dön");
            System.out.print("Seçiminiz: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Ders kodu: ");
                        String code = scanner.nextLine();
                        System.out.print("Ders adı: ");
                        String name = scanner.nextLine();
                        System.out.print("Kredi: ");
                        int credit = Integer.parseInt(scanner.nextLine());
                        System.out.print("Açık mı? (true/false): ");
                        boolean isOpen = Boolean.parseBoolean(scanner.nextLine());

                        Course newCourse = new Course(code, name, credit, isOpen);
                        CourseManager.addCourse(newCourse);
                        break;
                    case 2:
                        System.out.print("Silinecek dersin kodunu girin: ");
                        String codeToDelete = scanner.nextLine();
                        CourseManager.removeCourse(codeToDelete);
                        break;
                    case 3:
                        CourseManager.showAllCourses();
                        break;
                    case 4:
                        System.out.println("Çıkış yapılıyor...");
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                }
            } catch (Exception e) {
                System.out.println("Hata: " + e.getMessage());
            }

        } while (choice != 4);
    }
}
