package JavaLoginSystem;

public class Main {
    public static void main(String[] args) {
        IdAndPassword idAndPassword = new IdAndPassword();
        idAndPassword.getLoginInfo();
        LoginPage loginPage = new LoginPage(idAndPassword.getLoginInfo());
    }
}
