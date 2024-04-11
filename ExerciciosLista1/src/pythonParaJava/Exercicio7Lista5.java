package pythonParaJava;
import java.util.Scanner;


public class Exercicio7Lista5 {
public static void main(String[] args) {
	Scanner teclado =  new Scanner(System.in);
	
	System.out.print("Digite um numero: ");
	double numA = teclado.nextDouble();
	
	System.out.print("Digite outro numero: ");
	double numB = teclado.nextDouble();
	
	if ((numA - numB) > 0) {
		System.out.printf("O numero %.1f é maior que o numero %.1f por %.1f",numA, numB, numA-numB );
	}
	else if ((numB - numA)> 0) {
		System.out.printf("O numero %.1f é maior que o numero %.1f por %.1f",numB, numA, numB-numA);
	}
	else {
		System.out.println("Os numeros sao iguais");
	}
	
	
	
	teclado.close();
	
}
}
