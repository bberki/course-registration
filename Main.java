import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user;

        while (true) {
            System.out.println("\n=== JAVACS Giriş Ekranı ===");
            System.out.println("1. Öğrenci");
            System.out.println("2. Yönetici");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        user = new Student("Öğrenci");
                        user.showMenu();
                        break;
                    case 2:
                        user = new Admin("Yönetici");
                        user.showMenu();
                        break;
                    case 3:
                        System.out.println("Sistemden çıkılıyor...");
                        return;
                    default:
                        System.out.println("Geçersiz seçim.");
                }
            } catch (Exception e) {
                System.out.println("Hata: " + e.getMessage());
            }
        }
    }
}
