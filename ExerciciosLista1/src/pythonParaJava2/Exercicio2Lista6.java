package pythonParaJava2;

import java.util.Scanner;

public class Exercicio2Lista6 {
public static void main(String[] args) {
	Scanner teclado = new Scanner (System.in);
	
	int i = 1;
	
	double soma = 0;
	
	while (i<=2) {
		i+=1;
		System.out.print("Digite um numero: ");
		double numero = teclado.nextDouble();
		double resto = numero%3;
		soma += resto;
	}
	System.out.printf("A soma dos restos é %.1f", soma);
	
	
	
	
	
	teclado.close();
}
	
}
