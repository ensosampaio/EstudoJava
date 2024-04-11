package exercicios;
import java.util.Scanner;


public class Exercicio7Lista1 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite Px1: ");
	double px1 = teclado.nextDouble();
	
	System.out.print("Digite Px2: ");
	double px2 = teclado.nextDouble();
	
	System.out.print("Digite Py1: ");
	double py1= teclado.nextDouble();
	
	System.out.print("Digite Py2: ");
	double py2 = teclado.nextDouble();
	
	double soma = Math.pow((px2-px1), 2) + Math.pow((py2-py1), 2);
	double resultado = Math.sqrt(soma);
	
	
	
	System.out.printf("A distância entre os pontos (%.2f, %.2f) e (%.2f, %.2f) é %.2f", px1, py1, px2, py2, resultado);
	
	
	
	
	
	
	
	
	
	
	
	
	teclado.close();
}
}
