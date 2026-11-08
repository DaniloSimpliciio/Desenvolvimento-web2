public class App {
    public static void main(String[] args) throws Exception {
        Client client = new Client(1,"maria da silva","1234");

        BankAccount account = new BankAccount(1,client,-500);
        System.out.println(account);
    //     account.setId(2);
    //     account.setClient("joao");
    //     account.setBalance(1000.9999);
    //     System.out.println("codigo" + account.getId());
    //     System.out.println("nome" + account.getClientName());
    //    // System.out.printf("saldo: r$ %.2f|\n" + account.getBalance());
    //     account.deposit(1000);
        
    //     account.withdraw(500);
        
        
        // BankAccount account2 = new BankAccount(3,"adriana");
        // account2.deposit(300);
        // System.out.println("conta"+ account2);
       
    }
}
