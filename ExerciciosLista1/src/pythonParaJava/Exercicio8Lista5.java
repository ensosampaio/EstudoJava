package pythonParaJava;

import java.util.Scanner;

public class Exercicio8Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in); 
	
	System.out.print("Digite seu salário: ");
	double salario = teclado.nextDouble();
	
	if (salario<500) {
		double salarioA = salario*1.15;
		System.out.printf("Seu novo salário será R$%.2f", salarioA);
		
	}
	else if(salario>=500 || salario<=1000) {
		double salarioB = salario*1.10;
		System.out.printf("Seu novo salário será R$%.2f", salarioB);
	}
	else if (salario>1000) {
		double salarioC = salario*1.05;
		System.out.printf("Seu novo salário será R$%.3f", salarioC);
	}
	
	
	
	teclado.close();
}
}
