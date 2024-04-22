package exercicios;

import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite um numero: ");
		int numero = Integer.parseInt(teclado.nextLine());

		teclado.close();

		if (numeroPrimo(numero)) {
			System.out.println(numero + " é primo");
		} else {
			System.out.println(numero + " não é primo");
		}

	}

	public static boolean numeroPrimo(int numero) {
		if (numero <= 1) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(numero); i++) {
				if (numero % i == 0) {
					return false;
				}
			}
		}

		return true;
	}
}
