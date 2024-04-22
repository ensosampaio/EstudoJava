package exercicios;

import java.util.Scanner;

public class Exercicio6 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	
	System.out.print("Digite o numero fatorial desejado: ");
	double numero = teclado.nextDouble();
	int i = 1;
	int fatorial = 1;
	
	for (i = 1; i<=numero; i++) {
		fatorial *= i;
	}
	
	System.out.printf("O fatorial (%.0f!) do numero %.0f é: %d", numero, numero,fatorial);

	teclado.close();

}
}
