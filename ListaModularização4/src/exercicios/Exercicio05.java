package exercicios;

import java.util.Scanner;

public class Exercicio05 {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite a quantidade de numeros: ");
		int quantidade = Integer.parseInt(teclado.nextLine());

		double a[] = new double[quantidade];

		for (int i = 0; i < quantidade; i++) {
			System.out.print("Digite um numero: ");
			a[i] = Double.parseDouble(teclado.nextLine());
		}
		double pares[] = criarVetor(a);

		for (int i = 0; i < pares.length; i++) {
			System.out.println(pares[i]);
		}

		teclado.close();
	}

	public static double[] criarVetor(double a[]) {
		double novoVetor[] = new double[a.length];
		int contador = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				novoVetor[contador] = a[i];
				contador++;
			}
		}
		double novoVetorFinal[] = new double[contador];

		System.arraycopy(novoVetor, 0, novoVetorFinal, 0, contador);

		return novoVetorFinal;
	}

}
