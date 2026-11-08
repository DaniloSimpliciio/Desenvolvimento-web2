import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static PeopleManager manager = new PeopleManager();

    public static int menu() {
        System.out.println("-----------------------------------");
        System.out.println("--Sistema de Conttrole de Pessoas--");
        System.out.println("-----------------------------------");
        System.out.println("------MENU DE OPÇÕES---------------");
        System.out.println("-----------------------------------");
        System.out.println("1-Inserir");
        System.out.println("2-Buscar por cpf");
        System.out.println("3-Atualizar");
        System.out.println("4-Remover");
        System.out.println("5-listar");
        System.out.println("6- sair");
        System.out.println("-----------------------------------");
        System.out.println("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static void insert() {
        System.out.println("Digite o nome: ");
        String name = scanner.nextLine();
        System.out.println("Digite o cpf");
        String cpf = scanner.nextLine();
        Person person = new Person(name, cpf);
        if (manager.save(person)) {
            System.out.println("Pessoa inserida com sucesso");
        } else {
            System.out.println("pessoa não cadastrada");
        }
    }
    
    private static void search() {
    System.out.println("digite o CPF");
    String cpf = scanner.nextLine();
    Person person = manager.search(cpf);
    if(person!= null){
        System.out.println("Pessoa encontrada.Dados da pessoa: ");
        System.out.println(person);
    }else{System.out.println("pessoa não encontrada");

    }
    }

    public static void update(){
        System.out.println("Digite o nome");
        String name = scanner.nextLine();
        System.out.println("Digite o CPF");
        String cpf = scanner.nextLine();
        if(manager.update(name, cpf)){
            System.out.println("Dados atualizados com sucesso!");
        }else{System.out.print("Erro ao atualizar os dados.");

        }
    }

    public static void delete(){
    System.out.println("Digite o cpf");
    String cpf = scanner.nextLine();
    if(manager.delete(cpf)){
        System.out.println("Pessoa removida com sucesso!");
    }else{
        System.out.println("Erro ao remover a pessoa");
    }
    
    }

    public static void listar() {
    System.out.println("----- LISTA DE PESSOAS -----");

    for (Person person : manager.getPeopleLoList()) {
        System.out.println(person);
    }
}



    public static void main(String[] args) throws Exception {
        int option;

        do {
            option = menu();
            scanner.nextLine();
            switch (option) {
                case 1:
                    insert();
                    break;
                case 2:
                     search();
                    break;
                case 3:
                     update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("opção invalida. Tente novamente!");
                    break;
            }
            System.out.println("Precione ENTER para continuar......");
            scanner.nextLine();

        } while (option != 5);
        
    }

}
