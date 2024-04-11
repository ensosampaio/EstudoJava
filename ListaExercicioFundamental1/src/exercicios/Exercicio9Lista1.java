package exercicios;

import java.util.Scanner;

public class Exercicio9Lista1 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite a % de IPI do valor das peças: ");
	double IPI = teclado.nextDouble();
	
	System.out.print("Digite o código da peça 1: ");
	int cod1 = teclado.nextInt();
	
	System.out.print("Digite o preço unitário da peça 1: ");
	double preco1 = teclado.nextDouble();
	
	System.out.print("Digite quantas peças do tipo 1 serão compradas: ");
	int total1 = teclado.nextInt();
	
	System.out.print("Digite o código da peça 2: ");
	int cod2 = teclado.nextInt();
	
	System.out.print("Digite o preço unitário da peça 2: ");
	double preco2 = teclado.nextDouble();
	
	System.out.print("Digite quantas peças do tipo 2 serão compradas: ");
	int total2 = teclado.nextInt();
	
	double valorTotal = ((preco1*total1)+(preco2*total2))*(IPI/100+1);
	
	System.out.printf("O valor total a ser pago será R$%.2f",valorTotal);
	
	
	
	
	
	
	
	teclado.close();
}
}
