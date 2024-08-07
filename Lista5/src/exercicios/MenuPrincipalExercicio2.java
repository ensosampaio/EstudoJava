package exercicios;

import java.util.Scanner;

public class MenuPrincipalExercicio2 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Digite quantidade de funcionarios: ");
		int tamanho = Integer.parseInt(teclado.nextLine());
		EmpresaExercicio2 registro = new EmpresaExercicio2(tamanho);
		int opcao;

		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Cadastrar um vendedor");
			System.out.println("2. Mostrar todos os vendedores");
			System.out.println("3. Mostrar quantidade de vendedores de um produto");
			System.out.println("4. Excluir um vendedor");
			System.out.println("5. Finalizar operações");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarVendedor(registro);
				break;
			case 2:
				System.out.println("\n--- Lista de Vendedores ---");
				System.out.println(registro);
				break;
			case 3:
				quantidadeVendedorProduto(registro);
				break;
			case 4:
				excluirVendedor(registro);
				break;
			case 5:
				System.out.println("\nEncerrando o programa...");
				break;
			default:
				System.out.println("\nOpção inválida, por favor, tente novamente.");
			}
		} while (opcao != 5);
	}

	static void cadastrarVendedor(EmpresaExercicio2 a) {
		VendedorExercicio2 vendedorExercicio2 = new VendedorExercicio2();
		String nome;
		int codigoVendedor;
		char produtoVendido;

		System.out.println("\n--- Cadastro de Vendedor ---");
		System.out.print("Digite o nome do vendedor: ");
		nome = teclado.nextLine();

		System.out.print("Digite o código do vendedor: ");
		codigoVendedor = Integer.parseInt(teclado.nextLine());

		System.out.print("Digite o produto vendido (N ou P): ");
		produtoVendido = teclado.nextLine().charAt(0);

		vendedorExercicio2.setNomeVendedor(nome);
		vendedorExercicio2.setCodigoVendedor(codigoVendedor);
		vendedorExercicio2.setTipoMercadoria(produtoVendido);

		if (a.inserirVendedor(vendedorExercicio2)) {
			System.out.println("\nVendedor cadastrado com sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar o vendedor, arquivo cheio.");
		}
	}

	public static void quantidadeVendedorProduto(EmpresaExercicio2 a) {

		char produto;

		System.out.print("Digite o tipo do produto: ");

		produto = teclado.nextLine().charAt(0);

		int quantidade = a.contarVendedorMercadoria(produto);

		System.out.printf("A quantidades de vendedores para o produto %C é %d", produto, quantidade);

	}

	public static void excluirVendedor(EmpresaExercicio2 a) {
		System.out.println("\n--- Excluir Vendedor ---");
		System.out.print("Digite o nome do vendedor: ");
		String nome = teclado.nextLine();

		if (a.removerVendedor(nome)) {
			System.out.println("\nVendedor excluído com sucesso.");
		} else {
			System.out.println("\nVendedor não encontrado.");
		}
	}

}
