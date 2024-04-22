package exercicios;

import java.util.Scanner;

public class Exercicio04 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite uma palavra: ");
		String palavra = teclado.nextLine();

		System.out.println(contarVogar(palavra));

		teclado.close();
	}

	public static double contarVogar(String palavra) {
		int contadorVogal = 0;
		palavra.toLowerCase();
		for (int i = 0; i < palavra.length(); i++) {
			char c = palavra.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				contadorVogal += 1;
			}
		}

		return contadorVogal;
	}

}
