public class BankAccount {

    //declaração de atributos/ variaveis de instância
    private int id;
    private String clientName;//letra maiuscula no String por não ser do tipo primitivo, é uma classe.
    private double balance;

    //metodos construtores

    public BankAccount(int id, String clientName, double balance ){
        this.id = id;
        this.clientName = clientName;
        this.balance = balance;
    }

    public BankAccount(int id, String clientName){
        this(id,clientName,0);
    }

    // metodos acessadores

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public String getClientName(){
        return clientName;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }


    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amont){
        if(balance >= amont){
            balance -= amont;
        }
    }

    public String toString(){
        return "dados da conta" + "\ncodigo: " + id +"\nnome do cliente: "+clientName + "\nsaldo: R$ "+ balance;

    }

}
