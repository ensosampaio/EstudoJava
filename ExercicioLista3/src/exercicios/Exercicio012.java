package exercicios;

import java.util.Scanner;

public class Exercicio012 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite quantas pessoas serão contadas: ");
	String contador = teclado.nextLine();
	
	int contadorH = 0;
	int contadorM = 0;
	int contadorAlturaHomem = 0;
	double somadorAlturaMulher = 0;
	double mediaAltura = 0;
	
	for (int i=1; i<=Integer.parseInt(contador); i++) {
		
		System.out.print("Digite seu sexo (utilize H ou M): ");
		String sexo = teclado.nextLine();
		
		System.out.print("Digite sua altura: ");
		String altura = teclado.nextLine();
		
		if (sexo.equalsIgnoreCase("H")) {
			contadorH+=1;
			if (Double.parseDouble(altura)>1.70) {
				contadorAlturaHomem++;
			}
		}
		else if (sexo.equalsIgnoreCase("M")) {
			contadorM++;
		}
		if (contadorM == 0) {
			System.out.println("");
		}else {
			somadorAlturaMulher += Double.parseDouble(altura);
			mediaAltura = somadorAlturaMulher/contadorM;
		}
	
	
	
	}
	System.out.printf("Foram contados %d homens e %d mulheres", contadorH, contadorM);
	System.out.printf("\nTem %d homens acima de 1.70 de altura", contadorAlturaHomem);
	System.out.printf("\nA média das altuas das mulheres é: %.2fm",mediaAltura);
	
	
	teclado.close();
}
}
