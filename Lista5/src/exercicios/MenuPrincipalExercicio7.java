package exercicios;

import java.util.Scanner;

public class MenuPrincipalExercicio7 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		FolhaTrabalhoExercicio7 registro = new FolhaTrabalhoExercicio7(18);
		int opcao;

		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Cadastrar novo funcionario");
			System.out.println("2. Mostrar todas os trabalhadores");
			System.out.println("3. Alterar horas trabalhadas do funcionario");
			System.out.println("4. Calcular salário do funcionário");
			System.out.println("5. Encerrar programa");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarFuncionario(registro);
				break;
			case 2:
				System.out.println("\n--- Lista de Contas ---");
				System.out.println(registro);
				break;
			case 3:
				alterarHora(registro);
				break;
			case 4:
				calcularSalário(registro);
				break;
			case 5:
				System.out.println("\n--- Programa Encerrado ---");
			default:
				System.out.println("\nOpção inválida, por favor, tente novamente.");
			}
		} while (opcao != 5);
	}

	static void cadastrarFuncionario(FolhaTrabalhoExercicio7 a) {
		FuncionarioExercicio7 funcionario = new FuncionarioExercicio7();
		String nome;
		int horasTrabalhadas;
		char categoria;

		System.out.println("\n--- Cadastro de Funcionario ---");
		System.out.print("Digite o nome: ");
		nome = teclado.nextLine();

		System.out.print("Digite o numero de horas trabalhadas: ");
		horasTrabalhadas = Integer.parseInt(teclado.nextLine());

		System.out.print("Digite a categoria: ");
		categoria = teclado.nextLine().charAt(0);

		funcionario.setNome(nome);
		funcionario.setHoraTrabalhada(horasTrabalhadas);
		funcionario.setCategoria(categoria);

		if (a.cadastrarFuncionario(funcionario)) {
			System.out.println("\nFuncionário cadastrado com sucesso.");
		} else {
			System.out
					.println("\nNão foi possível cadastrar o cliente, verifique numero da conta ou tamanho do arquivo");
		}
	}

	static void alterarHora(FolhaTrabalhoExercicio7 a) {
		System.out.print("Digite o nome do funcionário: ");
		String nome = teclado.nextLine();

		System.out.print("Digite a nova quantidade de horas trabalhadas: ");
		int novaHora = Integer.parseInt(teclado.nextLine());

		boolean alterado = a.alterarHora(novaHora, nome);
		if (alterado) {
			System.out.println("Horas trabalhadas alteradas com sucesso.");
		} else {
			System.out.println("Funcionário não encontrado ou vetor vazio.");
		}
	}

	static void calcularSalário(FolhaTrabalhoExercicio7 a) {
		System.out.print("Digite o nome do funcionário: ");
		String nome = teclado.nextLine();

		boolean encontrado = false;
		for (int i = 0; i < a.getQuantVetor(); i++) {
			if (a.getVetor(i).getNome().equalsIgnoreCase(nome)) {
				double salario = a.calcularSalario(a.getVetor(i));
				System.out.println("Salário bruto de " + nome + ": R$" + salario);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Funcionário não encontrado.");
		}
	}
}
