package pythonParaJava2;

import java.util.Scanner;

public class Exercicio6Lista6 {
public static void main(String[] args) {
	
	Scanner teclado = new Scanner(System.in);
	
	double maior = 0;
	double altura;
	
	
	System.out.print("Digite sua altura ou digite 0 para parar o programa: ");
	while (true) {
		altura = teclado.nextDouble();
		if (altura == 0) {
			break;
		}
		
		if (altura>maior) {
			maior = altura;
		}
	}
	
	System.out.printf("A maior altura foi %.2f",maior);
	
	
	
	
	
	teclado.close();
}
}
