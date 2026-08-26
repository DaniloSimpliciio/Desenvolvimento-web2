public class BankAccount {

    //declaração de atributos/ variaveis de instância
    private int id;
    private     Client client;//letra maiuscula no String por não ser do tipo primitivo, é uma classe.
    private double balance;

    //metodos construtores

    public BankAccount(int id, Client client, double balance ){
        this.id = id;
        this.client = client;
        setBalance(balance);

    }

    public BankAccount(int id, Client client){
        this(id,client,0);
    }

    // metodos acessadores

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Client getClient(){
        return client;
    }

    public void setBalance(double balance){
        if (balance >=0){
            this.balance = balance;
        }
       
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
        return "dados da conta: " + "\ncodigo da conta: " + id + "\n" + client + "\nsaldo: R$ "+ balance;

    }

}
