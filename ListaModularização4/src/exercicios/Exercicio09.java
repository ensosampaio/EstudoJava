package exercicios;

import java.util.Scanner;

public class Exercicio09 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite o primeiro numero: ");
		int a = Integer.parseInt(teclado.nextLine());

		System.out.print("Digite o segundo numero: ");
		int b = Integer.parseInt(teclado.nextLine());

		System.out.println("MDC: " + calcularMDC(a, b));

		teclado.close();
	}

	public static int calcularMDC(int a, int b) {
		if (b == 0) {
			return a;
		} else
			return calcularMDC(b, Math.abs(a - b));
	}
}
