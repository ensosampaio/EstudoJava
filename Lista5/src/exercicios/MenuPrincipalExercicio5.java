package exercicios;

import java.util.Scanner;

public class MenuPrincipalExercicio5 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		FinanceiroExercicio5 registro = new FinanceiroExercicio5(1500);
		int opcao;

		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Cadastrar um financiamento");
			System.out.println("2. Mostrar todos os financiamentos");
			System.out.println("3. Alterar juros do maior financiamento");
			System.out.println("4. Finalizar operação");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarFinanciamento(registro);
				break;
			case 2:
				System.out.println("\n--- Lista de Financimento ---");
				System.out.println(registro);
				break;
			case 3:
				alterarJuros(registro);
				break;
			case 4:
				System.out.println("\nEncerrando o programa...");
				break;
			default:
				System.out.println("\nOpção inválida, por favor, tente novamente.");
			}
		} while (opcao != 5);
	}

	static void cadastrarFinanciamento(FinanceiroExercicio5 a) {
		ClienteExercicio5 cliente = new ClienteExercicio5();
		String nome;
		double valorEmprestimo;
		double jurosMes;

		System.out.println("\n--- Cadastro de Financiamento ---");
		System.out.print("Digite o nome do cliente: ");
		nome = teclado.nextLine();

		System.out.print("Digite o valor do emprestimo: ");
		valorEmprestimo = Double.parseDouble(teclado.nextLine());

		System.out.print("Digite o juros por mês: ");
		jurosMes = Double.parseDouble(teclado.nextLine());

		cliente.setNome(nome);
		cliente.setValorEmprestimo(valorEmprestimo);
		cliente.setJurosMes(jurosMes);

		if (a.cadastrarCliente(cliente)) {
			System.out.println("\nCliente cadastrado com sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar o cliente");
		}
	}

	static void alterarJuros(FinanceiroExercicio5 a) {
		System.out.println("\n--- Alterar Juros do Maior Financiamento ---");
		System.out.print("Digite para quanto será alterado a nova taxa: ");
		double novoJuros = Double.parseDouble(teclado.nextLine());

		boolean sucesso = a.alterarJuros(novoJuros);

		if (sucesso) {
			System.out.println("Juros do maior financiamento alterados com sucesso.");
		} else {
			System.out.println("Não foi possível alterar os juros do maior financiamento.");
		}

	}


}
