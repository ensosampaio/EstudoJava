package exercicios;

import java.util.Scanner;

public class Exercicio8Lista1 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite um numero: ");
	int numero = teclado.nextInt();
	
	int antecessor = numero-1;
	int sucessor = numero+1;
	
	System.out.printf("O numero %d tem como antecessor o numero %d e como sucessor o numero %d",numero,antecessor,sucessor);
	
	
	
	
	
	teclado.close();
}
}
