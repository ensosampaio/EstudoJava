package exercicios;

import java.util.Scanner;

public class Exercicio5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite o saldo médio do cliente: ");
	double saldoMedio = teclado.nextDouble();
	
	if (saldoMedio<=200) {
		System.out.printf("Seu saldo médio é %.2f e o valor do seu crédito é 0", saldoMedio);
	}else if (saldoMedio>200 && saldoMedio<=400) {
		System.out.printf("Seu saldo médio é %.2f e o valor do seu crédito é %.2f", saldoMedio, (saldoMedio*0.1));
	}else if (saldoMedio>400) {
		System.out.printf("Seu saldo médio é %.2f e o valor do seu crédito é %.2f", saldoMedio, (saldoMedio*0.2));
	}
	
	
	
	
	teclado.close();
}
}
