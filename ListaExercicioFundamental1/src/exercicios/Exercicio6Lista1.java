package exercicios;

import java.util.Scanner;

public class Exercicio6Lista1 {	
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite um numero inteiro: ");
	int numero = teclado.nextInt();
	
	int triplo = numero*3;
	double metade = (double) numero/2;
	double raizCubica = Math.cbrt(numero);
	double potencia = Math.pow(numero, 2.0/3.0);
	
	System.out.printf("O numero %d, possui %d como triplo, %.2f como metade, %.2f como raiz cubica e %.2f como potencia de 2/3", numero,triplo,metade,raizCubica,potencia);
	
	
	
	
	teclado.close();
}
}
