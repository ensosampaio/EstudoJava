package exercicios;

import java.util.Scanner;

public class MenuPrincipalExercicio4 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		EstoqueExercicio4 registro = new EstoqueExercicio4(40);
		int opcao;

		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Cadastrar um brinquedo");
			System.out.println("2. Mostrar todos os brinquedos");
			System.out.println("3. Mostrar lucro de determinado brinquedo");
			System.out.println("4. Mostrar produtos com quantidade abaixo do estoque minimo");
			System.out.println("5. Finalizar operações");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarBrinquedo(registro);
				break;
			case 2:
				System.out.println("\n--- Lista de Brinquedos ---");
				System.out.println(registro);
				break;
			case 3:
				lucroVenda(registro);
				break;
			case 4:
				estoqueAbaixo(registro);
				break;
			case 5:
				System.out.println("\nEncerrando o programa...");
				break;
			default:
				System.out.println("\nOpção inválida, por favor, tente novamente.");
			}
		} while (opcao != 5);
	}

	static void cadastrarBrinquedo(EstoqueExercicio4 a) {
		BrinquedoExercicio4 brinquedoExercicio4 = new BrinquedoExercicio4();
		int codigoBrinquedo;
		String descricaoBrinquedo;
		double precoCompra;
		double precoVenda;
		int estoque;
		int estoqueMin;

		System.out.println("\n--- Cadastro de Brinquedo ---");
		System.out.print("Digite o codigo do brinquedo: ");
		codigoBrinquedo = Integer.parseInt(teclado.nextLine());

		System.out.print("Digite a descrição do brinquedo: ");
		descricaoBrinquedo = teclado.nextLine();

		System.out.print("Digite o preço de compra do brinquedo: ");
		precoCompra = Double.parseDouble(teclado.nextLine());

		System.out.print("Digite o preço de venda do brinquedo: ");
		precoVenda = Double.parseDouble(teclado.nextLine());

		System.out.print("Digite a quantidade em estoque: ");
		estoque = Integer.parseInt(teclado.nextLine());

		System.out.print("Digite a quantidade minima possível em estoque: ");
		estoqueMin = Integer.parseInt(teclado.nextLine());

		brinquedoExercicio4.setCodigoBrinquedo(codigoBrinquedo);
		brinquedoExercicio4.setDescricaoBrinquedo(descricaoBrinquedo);
		brinquedoExercicio4.setPrecoCompra(precoCompra);
		brinquedoExercicio4.setPrecoVenda(precoVenda);
		brinquedoExercicio4.setEstoque(estoque);
		brinquedoExercicio4.setEstoqueMin(estoqueMin);

		if (a.cadastrarProduto(brinquedoExercicio4)) {
			System.out.println("\nBrinquedo cadastrado com sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar o brinquedo, arquivo cheio.");
		}
	}

	static void lucroVenda(EstoqueExercicio4 a) {

		int codigoBrinquedo;

		System.out.print("Digite o codigo do produto: ");

		codigoBrinquedo = Integer.parseInt(teclado.nextLine());

		double lucro = a.lucroVenda(codigoBrinquedo);

		System.out.printf("O lucro obtido pela venda do brinquedo com codigo %d é R$%.2f", codigoBrinquedo, lucro);

	}

	static void estoqueAbaixo(EstoqueExercicio4 a) {
		System.out.println("\n--- Produtos com estoque abaixo do minimo ---");
		for (int i = 0; i < a.getQuantVetor(); i++) {
			if (a.getVetor(i).getEstoque() < a.getVetor(i).getEstoqueMin()) {
				System.out.printf("Codigo: %d, Descricao: %s, Estoque: %d, Estoque minimo: %d\n",
						a.getVetor(i).getCodigoBrinquedo(), a.getVetor(i).getDescricaoBrinquedo(),
						a.getVetor(i).getEstoque(), a.getVetor(i).getEstoqueMin());
			}

		}
	}

}
