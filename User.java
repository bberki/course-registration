public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void showMenu(); // Student ve Admin bu metodu override edecek
}
