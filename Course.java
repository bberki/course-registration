public class Course {
    private String code;
    private String name;
    private int credit;
    private boolean isOpen;

    public Course(String code, String name, int credit, boolean isOpen) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.isOpen = isOpen;
    }

    // === Getters ===
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public boolean isOpen() {
        return isOpen;
    }

    // === Setters (isteğe bağlı) ===
    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    // === equals() override ===
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return code != null && code.equals(other.code);
    }

    // === hashCode() override (equals ile uyumlu olması için önerilir) ===
    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    // === toString() override ===
    @Override
    public String toString() {
        return String.format("[%s] %s - %d kredi - %s", 
            code, name, credit, isOpen ? "AÇIK" : "KAPALI");
    }
}
