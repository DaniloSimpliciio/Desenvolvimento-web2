public class App {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount();
        account.displayDetails();
        account.deposit(1000);
        account.displayDetails();
        account.withdraw(500);
        account.displayDetails();
        BankAccount account2 = new BankAccount();
        account2.deposit(300);
        account2.displayDetails();
    }
}
