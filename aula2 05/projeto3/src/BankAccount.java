public class BankAccount {

    //declaração de atributos/ variaveis de instância
    int id;
    String clientName;//letra maiuscula no String por não ser do tipo primitivo, é uma classe.
    double balance;


    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amont){
        if(balance >= amont){
            balance -=amont;
        }
    }

    public void displayDetails(){
        System.out.println("Dados da conta:");
        System.out.println("Código da conta: " + id);
        System.out.println("Nome do Cliente " + clientName);
        System.out.println("Saldo: R$ "+ balance);
    }

}
