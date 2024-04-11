package pythonParaJava;

import java.util.Scanner;
import java.lang.Math;



public class Exercicio11Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite o nome do paciente: ");
	String nome = teclado.next();
	
	System.out.print("Digite o peso do paciente: ");
	double peso = teclado.nextDouble();
	
	System.out.print("Digite a altura do paciente: ");
	double altura = teclado.nextDouble();
	
	double IMC = peso/(Math.pow(altura, 2));	
	
	if (IMC<20) {
		System.out.printf("O paciente %S está abaixo do peso", nome);
	}
	else if (IMC>=20 && IMC<25) {
		System.out.printf("O paciente %S está no peso normal", nome);
	}
	else if (IMC>=25 && IMC<35) {
		System.out.printf("O paciente %S está com excesso de peso", nome);
	}
	else if (IMC>=35 && IMC<50) {
		System.out.printf("O paciente %S está obeso", nome);
	}
	else if (IMC<50) {
		System.out.printf("");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	teclado.close();
}
}
