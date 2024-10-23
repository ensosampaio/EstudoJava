package ordenacao;

import java.util.Scanner;

import dados.Item;

public class BubbleSort {
	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		Scanner scan = new Scanner(System.in);
		//entrada de dados
		for (int i=0; i< 10; i++) {
			System.out.println("Digite um numero inteiro: ");
			vetor.inserirDados(new Item(scan.nextInt())) ;
		}
		vetor.bubblesort();
		System.out.println("vetor ordenado\n"+vetor.toString());
		System.out.println("bubblesort comparisons: " + vetor.getComparisons());
		System.out.println("bubblesort moves: " + vetor.getMoves());
	}

}
