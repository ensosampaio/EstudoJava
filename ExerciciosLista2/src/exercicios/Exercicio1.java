package exercicios;

import java.util.Scanner;

public class Exercicio1 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite o numerador: ");
	int numA = teclado.nextInt();
	
	System.out.print("Digite o denominador: ");
	int numB = teclado.nextInt();
	
	if (numB == 0) {
		System.out.println("Divisão indeterminada");
	}
	else {
		System.out.println(numA/numB);
	}
	
	
	
	
	
	
	
	
	teclado.close();
}
}
