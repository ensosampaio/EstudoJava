package pythonParaJava;

import java.util.Scanner;

public class Exercicio16Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite a média do aluno: ");
	double media = teclado.nextDouble();
	
	System.out.print("Digite o numero de faltas do aluno: ");
	int falta = teclado.nextInt();
	
	if (media<7 && falta>32) {
		System.out.println("Aluno reprovado por nota e falta");
	}
	else if(media<7) {
		System.out.println("Aluno reprovado por nota");
	}
	else if (falta>32) {
		System.out.println("Aluno reprovado por falta");
	}
	else {
		System.out.println("Aluno aprovado");
	}
	
	
	
	teclado.close();
}
}
