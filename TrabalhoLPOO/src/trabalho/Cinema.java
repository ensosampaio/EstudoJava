package trabalho;

import java.util.Scanner;

public class Cinema {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Assento assento = new Assento();

		int opcao;

		do {
			System.out.println("1- Cadastrar");
			System.out.println("2- Vender");
			System.out.println("3- Sair");

			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarFilme(assento);
				break;
			case 2:
				vendaCinema(assento);
				break;
			case 3:
				System.out.println("Saindo do sistema!");

			}

		} while (opcao != 3);

	}

	public static void cadastrarFilme(Assento assento) {
		Sessão sessão = new Sessão();

		System.out.println("Digite o nome do filme: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o horário da sessão: ");
		String horario = teclado.nextLine();

		sessão.setNomeFilme(nome);
		sessão.setHorario(horario);

		if (assento.eCheia() != true) {
			assento.adicionarFilme(sessão);
			System.out.println("Filme adicionado com sucesso!");
		} else {
			System.out.println("Programação já está completa!");
		}

	}

	public static void vendaCinema(Assento assento) {
		System.out.println(assento.exibirFilmes());

		System.out.println("Digite o nome do filme: ");
		String nome = teclado.nextLine();

		if (assento.checarFilme(nome) == false) {
			System.out.println("Filme não encontrado");
		} else {
			assento.exibirAssentos();
			System.out.println("Escolha a linha: ");
			int linha = Integer.parseInt(teclado.nextLine());
			System.out.println("Escolha a coluna: ");
			int coluna = Integer.parseInt(teclado.nextLine());

			if (assento.checarAssentos(linha, coluna)) {
				assento.vender(linha, coluna);
				System.out.println("Assento vendido!");
			} else {
				System.out.println("Assento " + linha + " " + coluna + " não disponível");
			}
		}

	}

}
