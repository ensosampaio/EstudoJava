package ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dados.Item;

public class Main {
	public static void main(String[] args) {
		String arquivo = "crescente_100.txt"; 
		int tamanho = 100; 
		Vetor vetor = new Vetor(tamanho);
		readFileAndInsertToVetor(arquivo, vetor);

		printarResultado(vetor, "Inserção direta", vetor::insercaoDireta);
		printarResultado(vetor, "Seleção direta", vetor::selecaoDireta);
		printarResultado(vetor, "Bubble Sort", vetor::bubblesort);
		printarResultado(vetor, "Shaker Sort", vetor::shakersort);
		printarResultado(vetor, "Shell Sort", vetor::shellSort);
		printarResultado(vetor, "Heap Sort", vetor::heapSort);
		printarResultado(vetor, "Quick Sort", vetor::quicksort);
	}

	private static void readFileAndInsertToVetor(String arquivo, Vetor vetor) {
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

	private static void printarResultado(Vetor vetor, String sortName, Runnable sortMethod) {
		vetor.resetarContadores();
		sortMethod.run();
		System.out.println(sortName + " comparações: " + vetor.getComparacao());
		System.out.println(sortName + " movimentos: " + vetor.getMovimentos());
	}
}