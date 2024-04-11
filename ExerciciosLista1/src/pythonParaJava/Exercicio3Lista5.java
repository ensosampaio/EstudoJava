package pythonParaJava;
import java.util.Scanner;


public class Exercicio3Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Pontuação do time A: ");
	int a = teclado.nextInt();
	
	System.out.print("Pontuação do time B: ");
	int b = teclado.nextInt();
	
	System.out.print("Pontuação do time C: ");
	int c = teclado.nextInt();
	
	if (a>b && b>c) {
		System.out.println("A ficou em primeiro, B em segundo e C em terceiro");
	}
	
	else if(a>c && c>b) {
		System.out.println("A ficou em primeiro, C em segundo e B em terceiro");
	}
	
	else if(b>a && a>c) {
		System.out.println("B ficou em primeiro, A em segundo e C em terceiro");
	}
	else if (b>c && c>a) {
		System.out.println("B ficou em primeiro, C em segundo e A em terceiro");
	}
	
	else if (c>a && a>b) {
		System.out.println("C ficou em primeiro, A em segundo e B em terceiro");
	}
	else if (c>b && b>a) {
		System.out.println("C ficou em primeiro, B em segundo e A em terceiro");
	}
	
	
	
	
	teclado.close();
}
}
