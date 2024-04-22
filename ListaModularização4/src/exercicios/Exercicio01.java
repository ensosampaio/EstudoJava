package exercicios;

import java.util.Scanner;

public class Exercicio01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int numero;
		System.out.print("Digite um numero: ");
		numero = Integer.parseInt(teclado.nextLine());

		System.out.println(enviarParOuImpar(numero));

		teclado.close();
	}

	public static boolean enviarParOuImpar(int a) {
		if (a % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}