package exercicios;

import java.util.Scanner;

public class Exercicio02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o numero desejado: ");
		double numero = Double.parseDouble(teclado.nextLine());
		System.out.printf("O fatorial do numero %.1f é %.1f", numero, calcularFatorial(numero));

		teclado.close();
	}

	public static double calcularFatorial(double a) {
		double i;
		double fatorial = 1;
		for (i = 1; i <= a; i++) {
			fatorial *= i;
		}
		return fatorial;
	}
}
