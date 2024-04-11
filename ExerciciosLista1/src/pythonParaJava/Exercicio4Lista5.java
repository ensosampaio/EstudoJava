package pythonParaJava;
import java.util.Scanner;

public class Exercicio4Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite o numero A: ");
	double a = teclado.nextDouble();
	
	System.out.print("Digite o numero B: ");
	double b = teclado.nextDouble();
	
	if (a==b) {
		System.out.println("Os numeros são iguais");
	}
	else if (a>b) {
		System.out.println("A é maior que B");
	}
	else if (b>a) {
		System.out.println("B é maior que A");
	}
	
	teclado.close();
}
}
