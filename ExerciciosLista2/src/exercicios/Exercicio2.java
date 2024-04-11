package exercicios;

import java.util.Scanner;

public class Exercicio2 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite um numero: ");
	int numero = teclado.nextInt();
	
	
	if (numero == 0) {
		System.out.println("\nO numero é zero");
	}
	else if (numero%2 == 0) {
		System.out.println("\nÉ um numero par");
	}
	else if (numero % 2 != 0) {
		System.out.println("\nÉ um numero impar");
	}
	
	
	
	
	System.out.println("\n\nFim do programa");
	teclado.close();
}
}
