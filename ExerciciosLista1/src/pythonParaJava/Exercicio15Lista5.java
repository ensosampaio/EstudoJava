package pythonParaJava;
import java.util.Scanner;


public class Exercicio15Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite seu salário: ");
	double salario = teclado.nextDouble();
	
	System.out.print("Digite o financiamento pretendido: ");
	double financiamento = teclado.nextDouble();
	
	if (financiamento<=salario*5) {
		System.out.println("\nFinanciamento concedido");
	}
	else {
		System.out.println("\nFinanciamento não concedido");
	}
	
	System.out.println("\nObrigado por nos consultar");
	
	
	
	
	
	
	teclado.close();
}
}
