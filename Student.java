import java.util.*;

public class Student extends User {
    private LessonCart<Course> cart = new LessonCart<>();
    private Scanner scanner = new Scanner(System.in);

    public Student(String name) {
        super(name);
    }

    @Override
    public void showMenu() {
        int choice = 0;
        do {
            System.out.println("\n=== Öğrenci Menüsü ===");
            System.out.println("1. Tüm dersleri göster");
            System.out.println("2. Ders ekle");
            System.out.println("3. Ders sepetini görüntüle");
            System.out.println("4. Ders sepetinden ders çıkar");
            System.out.println("5. Ders sepetini kaydet");
            System.out.println("6. Çıkış ve rol seçim ekranına dön");
            System.out.print("Seçiminiz: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        CourseManager.showAllCourses();
                        break;
                    case 2:
                        if (cart.isSaved()) {
                            System.out.println("Sepet zaten kaydedildi, ders eklenemez.");
                            break;
                        }
                        System.out.print("Eklemek istediğiniz ders kodunu girin: ");
                        String codeAdd = scanner.nextLine();
                        Course toAdd = CourseManager.findCourse(codeAdd);
                        if (toAdd == null) {
                            System.out.println("Böyle bir ders bulunamadı.");
                        } else if (!toAdd.isOpen()) {
                            System.out.println("Bu ders şu anda kapalı.");
                        } else {
                            cart.addCourse(toAdd);
                        }
                        break;
                    case 3:
                        cart.showCart();
                        break;
                    case 4:
                        if (cart.isSaved()) {
                            System.out.println("Sepet kaydedildi, ders silinemez.");
                            break;
                        }
                        System.out.print("Çıkarmak istediğiniz ders kodunu girin: ");
                        String codeRemove = scanner.nextLine();
                        cart.removeCourseByCode(codeRemove);
                        break;
                    case 5:
                        cart.saveCart();
                        break;
                    case 6:
                        System.out.println("Çıkış yapılıyor...");
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                }
            } catch (Exception e) {
                System.out.println("Hata: " + e.getMessage());
            }

        } while (choice != 6);
    }
}
