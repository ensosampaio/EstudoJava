package pythonParaJava;
import java.util.Scanner;


public class Exercicio2Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite um numero: ");
	double numero = teclado.nextDouble();
	
	if (numero == 1.5 || numero == 10) {
		System.out.println("O numero é igual");
	}
	else {
		System.out.println("Numero inválido");
	}
	
	
	teclado.close();
}
}
