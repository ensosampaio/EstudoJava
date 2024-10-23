package ordenacao;

import java.util.Scanner;

import dados.Item;

public class HeapSort {
	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		Scanner scan = new Scanner(System.in);
		//entrada de dados
		for (int i=0; i< 10; i++) {
			System.out.println("Digite um n�mero inteiro: ");
			vetor.inserirDados(new Item(scan.nextInt())) ;
		}
		vetor.heapSort();
		System.out.println("vetor ordenado\n"+vetor.toString());
	}

}
