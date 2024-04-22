package exercicios;

import java.util.Scanner;

public class Exercicio03 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o tamanho do vetor: ");
		int tamanho = Integer.parseInt(teclado.nextLine());
		double a[] = new double[tamanho];

		for (int i = 0; i < tamanho; i++) {
			System.out.print("Digite um numero: ");
			a[i] = Double.parseDouble(teclado.nextLine());
		}

		System.out.println("O maior numero do vetor é: " + maiorValor(a));

		teclado.close();
	}

	public static double maiorValor(double vetor[]) {

		double maior = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > maior) {
				maior = vetor[i];
			}
		}

		return maior;

	}

}
