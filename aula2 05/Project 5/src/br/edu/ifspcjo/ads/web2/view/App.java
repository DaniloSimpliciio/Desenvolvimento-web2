package br.edu.ifspcjo.ads.web2.view;

import java.util.Scanner;

import br.edu.ifspcjo.ads.web2.controller.EmpolyeersController;
//import br.edu.ifspcjo.ads.web2.model.Employee;
//import br.edu.ifspcjo.ads.web2.model.HourEmployee;
import br.edu.ifspcjo.ads.web2.model.SalarieEmployee;


public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static EmpolyeersController manager  = new EmpolyeersController();

    public static int menu() {

        System.out.println("-----------------------");
        System.out.println("1 -Salario-------------");
        System.out.println("2 - Procurar produto---");
        System.out.println("3 - Atualizar estoque--");
        System.out.println("4 - ------");
        System.out.println("5 - ---------------");
        System.out.println("-----------------------");

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
        System.out.println("Código: ");
        String nome = scanner.nextLine();

        System.out.println("Nome do produto: ");
        String cpf = scanner.nextLine();

        System.out.println("Quantidade: ");
        double quantidade = scanner.nextDouble();

        SalarieEmployee salarieEmployee = new SalarieEmployee(nome, cpf, quantidade);

        if (manager.save(salarieEmployee)) {
            System.out.println("Produto salvo!");
        } else {
            System.out.println("Código repetido! Produto não foi salvo.");
        }


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
                    
                        default:
                            break;
                    }
                    }while (opcao !=5);
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

