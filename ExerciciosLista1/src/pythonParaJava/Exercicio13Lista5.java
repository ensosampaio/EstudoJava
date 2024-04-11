package pythonParaJava;
import java.util.Scanner;


public class Exercicio13Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite um numero qualquer: ");
	double num = teclado.nextDouble();
	
	if ((num%3)==0) {
		System.out.printf("O numero %.1f é divisivel por 3",num);
	}
	else {
		System.out.printf("O numero %.1f não é divisivel por 3", num);
	}
	if ((num%7)==0) {
		System.out.printf("\nO numero %.1f é divisivel por 7", num);
	}
	else {
		System.out.printf("\nO numero %.1f não é divisivel por 7", num);
	}
	
	
	
	
	
	teclado.close();
}
}
