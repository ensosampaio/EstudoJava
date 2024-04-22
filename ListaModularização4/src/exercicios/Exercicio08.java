package exercicios;

import java.util.Scanner;

public class Exercicio08 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o numero de elementos: ");
		int elementos = Integer.parseInt(teclado.nextLine());

		int vetor[] = new int[elementos];

		System.out.print("Digite um numero inteiro qualquer: ");
		int numero = Integer.parseInt(teclado.nextLine());

		for (int i = 0; i < elementos; i++) {
			System.out.print("Digite um numero: ");
			vetor[i] = Integer.parseInt(teclado.nextLine());
		}

		int maior[] = novoVetor(vetor, numero);

		for (int i = 0; i < maior.length; i++) {
			System.out.println(maior[i]);
		}

		teclado.close();
	}

	public static int[] novoVetor(int vetor[], int numero) {

		int novoVetor[] = new int[vetor.length];
		int contador = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > numero) {
				novoVetor[contador] = vetor[i];
				contador++;
			}

		}
		int novoVetorFinal[] = new int[contador];

		System.arraycopy(novoVetor, 0, novoVetorFinal, 0, contador);
		return novoVetorFinal;

	}

}
