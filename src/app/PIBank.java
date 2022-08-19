package app;

import model.contaBancaria;
import model.contaEspecial;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PIBank {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int option;
        String nomeTitular, cpf, cpfValidate;
        Random random = new Random();
        String numero = String.format("%04d", random.nextInt(10000));
        String contaPremium;

        ArrayList<contaBancaria> clientes = new ArrayList<contaBancaria>();
        contaBancaria cliente = null;

        System.out.println("Bem vindo ao PI Bank, realize seu cadastro");

        System.out.println("Informe seu nome: ");
        nomeTitular = reader.nextLine();
        System.out.println("Informe seu CPF: ");
        cpf = reader.nextLine();
        System.out.println("Deseja ativar a conta premium e ter acesso à diversos benefícios? \n[S] / [N]");
        contaPremium = reader.nextLine();
        switch (contaPremium.toUpperCase()) {
            case "S":
                cliente = new contaEspecial(nomeTitular, cpf, numero, 100.00, 500.00);
                break;
            case "N":
                cliente = new contaBancaria(nomeTitular, cpf, numero, 100.00);
                break;
            default:
                System.out.println("Insira [S] ou [N]");
                break;
        }

        if (cliente == null) {
            System.out.println("Erro ao realizar cadastro. Tente novamente.");
            System.exit(1);
        }

        clientes.add(cliente);

        System.out.println("Cadastro realizado.");
        System.out.println(cliente);

        do {

            System.out.println("Deseja realizar um depósito ou saque?\n[1] Saque\n[2] Depósito\n[0] Sair");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Informe seu CPF: ");
                    cpfValidate = reader.next();
                    if (cliente.getCpf().equals(cpfValidate)) {
                        System.out.println("Informe o valor que deseja sacar");
                        double valor = reader.nextDouble();
                        cliente.debitar(valor);
                        System.out.println(cliente);
                    } else {
                        System.out.println("CPF não encontrado no sistema. Verifique se digitou corretamente ou realize " +
                                           "seu cadastro.");
                    }
                    break;

                case 2:
                    System.out.println("Informe seu CPF: ");
                    cpfValidate = reader.next();
                    if (cliente.getCpf().equals(cpfValidate)) {
                        System.out.println("Informe o valor que deseja depositar");
                        double valor = reader.nextDouble();
                        cliente.creditar(valor);
                        System.out.println(cliente);
                    } else {
                        System.out.println("CPF não encontrado no sistema. Verifique se digitou corretamente ou realize " +
                                           "seu cadastro.");
                    }
                    break;
            }

        } while (option != 0);


    }
}
