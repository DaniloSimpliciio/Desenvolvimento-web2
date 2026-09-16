package br.edu.ifspcjo.ads.web2.view;

import java.util.Scanner;

import br.edu.ifspcjo.ads.web2.controller.EmpolyeersController;
import br.edu.ifspcjo.ads.web2.model.ComissionedAndSalarieEmployee;
import br.edu.ifspcjo.ads.web2.model.ComissionedEmployee;
import br.edu.ifspcjo.ads.web2.model.Employee;
import br.edu.ifspcjo.ads.web2.model.Employee;
import br.edu.ifspcjo.ads.web2.model.HourEmployee;
import br.edu.ifspcjo.ads.web2.model.SalarieEmployee;


public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static EmpolyeersController manager  = new EmpolyeersController();

    public static int menu() {

        System.out.println("---------------------------");
        System.out.println("1 - Cadastro Funcionários--");
        System.out.println("2 - Listar Salario---------");
        System.out.println("3 - -----------------------");
        System.out.println("4 - -----------------------");
        System.out.println("5 - -----------------------");
        System.out.println("---------------------------");

        return scanner.nextInt();
    }

        public static int menu2() {

        System.out.println("--------------------------------------------");
        System.out.println("1 - Funcionário Assalariado-----------------");
        System.out.println("2 - Funcionário Horista---------------------");
        System.out.println("3 - Funcionário Comissionado----------------");
        System.out.println("4 - Funcionario Comissionado e Assalariado--");
        System.out.println("5 - Sair------------------------------------");
        System.out.println("--------------------------------------------");

        return scanner.nextInt();

    }


        public static void adicionarSalarieEmployee() {

        scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Salario: ");
        double Salary = scanner.nextDouble();

        SalarieEmployee salarieEmployee = new SalarieEmployee(nome, cpf, Salary);

        if (manager.save(salarieEmployee)) {
            System.out.println("Produto salvo!");
        } else {
            System.out.println("Código repetido! Produto não foi salvo.");
        }
        }


        public static void adicionarHourEmployee(){
            scanner.nextLine();
            System.out.println("nome: ");
            String name = scanner.nextLine();

            System.out.println("cpf: ");
            String cpf = scanner.nextLine();

            System.out.println("Numero de horas trabalhadas: ");
            int number = scanner.nextInt();

            System.out.println("Valor da hora: ");
            double value = scanner.nextDouble();

            HourEmployee hourEmployee = new HourEmployee(name,cpf, number, value);
            if(manager.save(hourEmployee)){
                System.out.println("Funcionario salvo!!");
            }
            else{System.out.println("Não salvo!");}
        }


        public static void adicionarComissionedEmployee(){
            scanner.nextLine();
            System.out.println("nome: ");
            String name = scanner.nextLine();

            System.out.println("cpf: ");
            String cpf = scanner.nextLine();
            
            System.out.println("Venda: ");
            double sales = scanner.nextDouble();

            System.out.println("Porcentagem: ");
            double porcentagem = scanner.nextDouble();
            

            ComissionedEmployee ComissionedEmployee = new br.edu.ifspcjo.ads.web2.model.ComissionedEmployee(name,cpf, sales,porcentagem);
            if(manager.save(ComissionedEmployee)){
            System.out.println("Funcionario salvo!!");
            }
            else{System.out.println("Não salvo!");}
        }

            public static void adicionarComissionedAndSalarieEmployee(){
            scanner.nextLine();

             System.out.println("nome: ");
            String name = scanner.nextLine();

            System.out.println("cpf: ");
            String cpf = scanner.nextLine();
            
            System.out.println("Venda: ");
            double sales = scanner.nextDouble();

            System.out.println("Porcentagem: ");
            double porcentagem = scanner.nextDouble();

            System.out.println("Salario: ");
            double salario = scanner.nextDouble();
            

            ComissionedAndSalarieEmployee comissionedAndSalarieEmployee = new ComissionedAndSalarieEmployee(name,cpf,sales,porcentagem,salario);
            if(manager.save(comissionedAndSalarieEmployee)){
            System.out.println("Funcionario salvo!!");
            }
            else{System.out.println("Não salvo!");}    

            }




    //private static EmpolyeersController empolyeersController = new EmpolyeersController();
      public static void main(String[] args) throws Exception {/* 
     Employee employee1 = new SalarieEmployee("Adriana","1234", 3000);
     empolyeersController.save(employee1);
     System.out.println(employee1);
     System.out.println(employee1.calculateIncome());
     Employee employee2 = new HourEmployee("Juliana", "5678", 10, 100);
     System.out.println(employee2.calculateIncome());
      */
     
             int opcao;
             int opcao2;

        do {
            opcao = menu();
            switch (opcao) {

                case 1:
                    do{
                        
                    opcao2 = menu2();

                    switch (opcao2) {
                        case 1:
                            adicionarSalarieEmployee();
                            break;
                        case 2:
                            adicionarHourEmployee(); 
                            break;
                        case 3:
                            adicionarComissionedEmployee();
                            break;
                        case 4:
                            adicionarComissionedAndSalarieEmployee();
                            break;
                        case 5:
                            System.out.println("Programa encerrado.");
                            break;
                        default:
                            System.out.println("opção inválida!");
                            break;
                    }
                    }while (opcao2 !=5);
                    break;

                case 2: manager.list();
                     break;
                case 5:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
}
}


