package application;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(" == CADASTRO DO CLIENTE == ");
        System.out.println("       = BEM-VINDO = ");
        System.out.println();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento: (dd/MM/yyyy): ");
        Date dataDeNascimento = sdf.parse(sc.next());

        Cliente cliente1 = new Cliente(nome, email, dataDeNascimento);
        Conta c1 = new ContaCorrente(cliente1);
        Conta p2 = new ContaPoupanca(cliente1);

        System.out.println();
        System.out.println(cliente1);
        c1.imprimirExtrato();
        p2.imprimirExtrato();

        System.out.println();
        System.out.print("Digite a quantia para realizar um depósito: ");
        Double valor = sc.nextDouble();
        System.out.print("O depósito será feito na Conta Corrente ou na Conta Poupança? (c/p)? ");
        char ch = sc.next().charAt(0);
        if (ch == 'c'){
            c1.depositar(valor);
        }
        else if (ch == 'p'){
            p2.depositar(valor);
        }

        c1.imprimirExtrato();
        p2.imprimirExtrato();
        System.out.println();

        System.out.print("Digite a quantia para realizar um saque: ");
        valor = sc.nextDouble();
        if (ch == 'c'){
            c1.sacar(valor);
        }
        else if (ch == 'p'){
            p2.sacar(valor);
        }

        System.out.println();
        c1.imprimirExtrato();
        p2.imprimirExtrato();
        System.out.println();

        System.out.print("Digite a quantia para realizar uma transferência: ");
        valor = sc.nextDouble();
        c1.transferir(valor, p2);

        System.out.println();
        c1.imprimirExtrato();
        p2.imprimirExtrato();
        System.out.println();

        sc.close();
    }
}