package exercicios;

import java.util.Scanner;

public class Exercicio3 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite o primeiro numero: ");
	double numA = teclado.nextInt();
	
	System.out.print("Digite o proximo numero: ");
	double numB = teclado.nextInt();
	
	System.out.print("Digite a operação matematica (*,-,+,/): ");
	String operação = teclado.next();
	
	switch (operação) {
		case ("+"):
			double adicao = numA+numB;
			System.out.println(adicao);
			break;
		
		case ("-"):
			double subtracao = numA - numB;
			System.out.println(subtracao);
			break;
		case ("*"):
			double multiplicacao = numA*numB;
			System.out.println(multiplicacao);
			break;
		case ("/"):
			if (numB == 0) {
				System.out.println("Divisão impossível");
			}
			else {
				double divisao = numA/numB;
				System.out.println(divisao);
			break;
			
			}
	
		default:
			System.out.println("Erro: operação invalida");
	
	}
	
	
	
	
	
	
	
	teclado.close();
}
}
