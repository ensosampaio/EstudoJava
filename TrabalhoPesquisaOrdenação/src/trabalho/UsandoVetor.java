package trabalho;

import java.util.Random;
import java.util.Scanner;

import dados.Item;

public class UsandoVetor {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o tamanho do vetor: ");
		int tamanho = Integer.parseInt(teclado.nextLine());

		Vetor vetor = new Vetor(tamanho);

		System.out.println("Deseja preencher o vetor manualmente (m) ou aleatoriamente (a)?");
		String opcao = teclado.nextLine();

		if (opcao.equalsIgnoreCase("m")) {
			preencherVetorManual(vetor, teclado);
		} else if (opcao.equalsIgnoreCase("a")) {
			preencherVetorAleatorio(vetor);
		} else {
			System.out.println("Opção inválida!");
			teclado.close();
			return;
		}

		System.out.println("Vetor preenchido:");
		System.out.println(vetor.imprimirVetor());

		System.out.println("Digite a chave que voce quer procurar: ");
		int chave = Integer.parseInt(teclado.nextLine());

		compararPesquisas(vetor, chave);
		teclado.close();
	}

	private static void preencherVetorManual(Vetor vetor, Scanner teclado) {
		for (int i = 0; i < vetor.getTamanho(); i++) {
			System.out.println("Digite o valor para a posição " + i + ": ");
			int valor = Integer.parseInt(teclado.nextLine());
			Item item = new Item(valor);
			vetor.inserirDados(item);
		}
	}

	private static void preencherVetorAleatorio(Vetor vetor) {
		Random random = new Random();
		for (int i = 0; i < vetor.getTamanho(); i++) {
			int valor = random.nextInt(10000);
			Item item = new Item(valor);
			vetor.inserirDados(item);
		}
	}

	public static void compararPesquisas(Vetor vetor, int chave) {
		long startTimeSeq = System.nanoTime();
		int indiceSeq = vetor.pesquisaSequencial(chave);
		long endTimeSeq = System.nanoTime();
		long tempoSeq = endTimeSeq - startTimeSeq;

		long startTimeBin = System.nanoTime();
		int indiceBin = vetor.pesquisaBinaria(chave);
		long endTimeBin = System.nanoTime();
		long tempoBin = endTimeBin - startTimeBin;

		long startTimeHash = System.nanoTime();
		int indiceHash = vetor.pesquisaHashing(chave);
		long endTimeHash = System.nanoTime();
		long tempoHash = endTimeHash - startTimeHash;

		System.out.println("Pesquisa Sequencial:");
		System.out.println("Índice: " + (indiceSeq != -1 ? indiceSeq : "não encontrado"));
		System.out.println("Tempo: " + tempoSeq + " ns");
		System.out.println("Comparações: " + vetor.getComparacoesSeq());

		System.out.println("\nPesquisa Binária:");
		System.out.println("Índice: " + (indiceBin != -1 ? indiceBin : "não encontrado"));
		System.out.println("Tempo: " + tempoBin + " ns");
		System.out.println("Comparações: " + vetor.getComparacoesBin());

		System.out.println("\nPesquisa Hashing:");
		System.out.println("Índice: " + (indiceHash != -1 ? indiceHash : "não encontrado"));
		System.out.println("Tempo: " + tempoHash + " ns");
	}
}
