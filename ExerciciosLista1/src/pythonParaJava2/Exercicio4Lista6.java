package pythonParaJava2;

import java.util.Scanner;

public class Exercicio4Lista6 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	int fatorial = 1;
	
	System.out.print("Digite um numero: ");
	int numero = teclado.nextInt();
	
	
	
	for (int contador=1; contador<=numero; contador++ ) {
		fatorial *= contador;
	}
	System.out.printf("O fatorial do numero %d é %d", numero, fatorial);
	
	
	
	
	
	teclado.close();
}
}
