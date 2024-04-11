package exercicios;

import java.util.Scanner;

public class Exercicio_13 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite a quantidade de hastes de cobre: ");
	int hasteCobre = teclado.nextInt();
	
	System.out.print("Digite a quantidade de haster de aluminio: ");
	int hasteAluminio = teclado.nextInt();
	
	int quantidadeCompra = hasteCobre + hasteAluminio;
	
	
	double desconto;
	double valorTotal = (hasteCobre*2)+(hasteAluminio*4);
	double valorDesconto;
	
	
	if (quantidadeCompra<5) {
		desconto = 0;
		System.out.printf("O valor da sua compra de %d hastes foi R$%.2f", quantidadeCompra,valorTotal);
	}
	
	else if (quantidadeCompra>= 5 && quantidadeCompra<=15) {
		desconto = 0.1;
		valorDesconto = valorTotal - (valorTotal*desconto);
		System.out.printf("O valor da sua compra de %d hastes foi R$%.2f", quantidadeCompra,valorDesconto);
	}
	else if (quantidadeCompra >= 16 && quantidadeCompra<=20) {
		desconto = 0.15;
		valorDesconto = valorTotal - (valorTotal*desconto);
		System.out.printf("O valor da sua compra de %d hastes foi R$%.2f", quantidadeCompra,valorDesconto);
	}
	else if (quantidadeCompra>20) {
		desconto = 0.2;
		valorDesconto = valorTotal - (valorTotal*desconto);
		System.out.printf("O valor da sua compra de %d hastes foi R$%.2f", quantidadeCompra,valorDesconto);
	}

	teclado.close();
}
}
