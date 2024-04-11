package exercicios;

import java.util.Scanner;

public class Exercicio3 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	double numero = 0;
	int contadorNumero = 0;
	double somadorNumero = 0;
	while (numero != -1) {
		System.out.println("Digite um numero: ");
		numero = teclado.nextDouble();
		if (numero!= -1) {
			contadorNumero++;
			somadorNumero += numero;
		}
	}
	System.out.printf("A média dos numeros digitados foi: %.2f", (somadorNumero/contadorNumero));
	
	
	
	
	
	
	
	
	
	
	
	
	
	teclado.close();
}
}
