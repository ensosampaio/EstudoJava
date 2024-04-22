package exercicios;

import java.util.Scanner;

public class Exercicio07 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		String nome = teclado.nextLine();

		System.out.println(removerSobrenome(nome));

		teclado.close();
	}

	public static String removerSobrenome(String nome) {

		String partes[] = nome.split(" ");

		String primeiroNome = partes[0];

		return primeiroNome;

	}

}
