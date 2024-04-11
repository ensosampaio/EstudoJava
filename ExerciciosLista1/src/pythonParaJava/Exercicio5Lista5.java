package pythonParaJava;
import java.util.Scanner;

public class Exercicio5Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner (System.in);
	
	System.out.print("Digite um numero: ");
	double numero = teclado.nextDouble();
	
	if (numero>0) {
		System.out.println("Seu numero é positivo!");
	}
	else if (numero<0) {
		System.out.println("Seu numero é negativo!");
	}
	else if (numero == 0) {
		System.out.println("Voce digitou um numero nulo!");
	}
	
	teclado.close();
}
}
