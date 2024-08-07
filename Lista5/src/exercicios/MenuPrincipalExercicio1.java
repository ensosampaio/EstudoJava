package exercicios;

import java.util.Scanner;

public class MenuPrincipalExercicio1 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Digite quantos filmes podem ser registrados: ");

		int tamanho = Integer.parseInt(teclado.nextLine());

		char opcao;

		LocadoraExercicio1 locadoraExercicio1 = new LocadoraExercicio1(tamanho);

		do {
			System.out.println("1.Cadastrar um filme no arquivo(vetor)\n" + "2.Mostrar todos os filmes\n"
					+ "3.Mostrar quantidade de filmes de um genero\n" + "4.Excluir um filme do arquivo (Vetor)\n"
					+ "5.Finalizar operações");
			opcao = teclado.next().charAt(0);
			switch (opcao) {
			case '1':
				cadastrarFilme(locadoraExercicio1);
				break;
			case '2':
				System.out.println(locadoraExercicio1.toString());
				break;
			case '3':
				quantidadeFilmeGenero(locadoraExercicio1);
				break;
			case '4':
				excluirFilme(locadoraExercicio1);
				break;
			case '5':
				System.out.println("Fim do programa");
				break;
			default:
				System.out.println("Opção errada, tente novamente.");
			}
		} while (opcao != '5');

	}

	static void cadastrarFilme(LocadoraExercicio1 a) {

		FilmesExercicio1 filme = new FilmesExercicio1();

		int codigo;

		String titulo;

		char genero;

		System.out.print("Digite o código do filme: ");

		codigo = Integer.parseInt(teclado.nextLine());

		System.out.print("\nDigite o titulo do filme: ");
		titulo = teclado.nextLine();

		System.out.print("\nDigite o genero do filme: ");
		genero = teclado.nextLine().charAt(0);

		filme.setCodigo(codigo);
		filme.setTitulo(titulo);
		filme.setGenero(genero);

		if (a.inserirFilme(filme)) {
			System.out.println("\nOperação realizada com sucesso.\n");
		} else {
			System.out.println("\nOperação não realizada, arquivo cheio\n");
		}

	}

	public static void quantidadeFilmeGenero(LocadoraExercicio1 locadoraExercicio1) {
		char genero;

		System.out.println("Digite o gênero do filme:");
		genero = teclado.next().charAt(0);
		int quantidade = locadoraExercicio1.contarFilmesGenero(genero);
		System.out.println("Número de filmes do gênero '" + genero + "': " + quantidade);
	}

	static void excluirFilme(LocadoraExercicio1 a) {
		String nome;
		teclado.nextLine();
		System.out.print("Digite o nome do filme: ");
		nome = teclado.nextLine();
		if (a.removerFilme(nome)) {
			System.out.println("Operação realizada com sucesso");
		} else {
			System.out.println("Operação não realizada, filme não encontrado");
		}
	}

}
