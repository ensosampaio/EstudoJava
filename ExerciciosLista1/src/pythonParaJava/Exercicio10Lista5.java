package pythonParaJava;
import java.util.Scanner;


public class Exercicio10Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Quantos salários minimos voce recebe? ");
	int salario = teclado.nextInt();
	
	if (salario>= 10) {
		System.out.println("Sortudo!");
	}
	else if (salario>=6 && salario<=9) {
		System.out.println("Um dia voce chega lá!");
	}
	else if (salario<6) {
		System.out.println("Coitado!");
	}
	
	
	
	
	
	teclado.close();
}
	
	
}
