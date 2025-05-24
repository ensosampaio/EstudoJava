package trabalho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import dados.Item;

public class UsandoArquivo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String arquivo = "a.txt"; // Coloque "crescente.txt", "decrescente.txt" ou "aleatorio.txt"
		int tamanho = 9;

		Vetor vetor = new Vetor(tamanho);
		lerArquivoInserirVetor(arquivo, vetor);

		System.out.println("Digite a chave que voce quer procurar: ");
		int chave = Integer.parseInt(teclado.nextLine());

		contarSequencial(vetor, chave);
		contarBinaria(vetor, chave);
		contarHash(vetor, chave);
		teclado.close();
	}

	public static void contarSequencial(Vetor vetor, int chave) {
		vetor.bubblesort();
		long startTimeSeq = System.nanoTime();
		int indiceSeq = vetor.pesquisaSequencial(chave);
		long endTimeSeq = System.nanoTime();
		long tempoSeq = endTimeSeq - startTimeSeq;

		System.out.println("Pesquisa Sequencial:");
		System.out.println("Índice: " + (indiceSeq != -1 ? indiceSeq : "não encontrado"));
		System.out.println("Tempo: " + tempoSeq + " ns");
		System.out.println("Comparações: " + vetor.getComparacoesSeq());
	}

	private static void lerArquivoInserirVetor(String arquivo, Vetor vetor) {
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				int chave = Integer.parseInt(linha.trim());
				Item item = new Item(chave);
				vetor.inserirDados(item);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void contarBinaria(Vetor vetor, int chave) {
		vetor.bubblesort();
		long startTimeBin = System.nanoTime();
		int indiceBin = vetor.pesquisaBinaria(chave);
		long endTimeBin = System.nanoTime();
		long tempoBin = endTimeBin - startTimeBin;

		System.out.println("\nPesquisa Binária:");
		System.out.println("Índice: " + (indiceBin != -1 ? indiceBin : "não encontrado"));
		System.out.println("Tempo: " + tempoBin + " ns");
		System.out.println("Comparações: " + vetor.getComparacoesBin());
	}

	public static void contarHash(Vetor vetor, int chave) {
		long startTimeHash = System.nanoTime();
		int indiceHash = vetor.pesquisaHashing(chave);
		long endTimeHash = System.nanoTime();
		long tempoHash = endTimeHash - startTimeHash;

		System.out.println("\nPesquisa Hashing:");
		System.out.println("Índice: " + (indiceHash != -1 ? indiceHash : "não encontrado"));
		System.out.println("Tempo: " + tempoHash + " ns");
	}

}
