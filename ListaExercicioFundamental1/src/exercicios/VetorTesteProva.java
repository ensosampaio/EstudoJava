package exercicios;

import java.util.Scanner;

public class VetorTesteProva {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	
	System.out.print("Digite a quantidade de pacientes: ");
	int pessoas = Integer.parseInt(teclado.nextLine());
	
	String nome [] = new String[pessoas];
	int idade [] = new int[pessoas];
	
	for (int i = 0; i<pessoas; i++) {
		System.out.print("Digite o nome do paciente: ");
		nome[i] = teclado.nextLine();
		
		System.out.print("Digite a idade do paciente: ");
		idade[i] = Integer.parseInt(teclado.nextLine());
	}
	
	System.out.printf("Total de pacientes: %d\n", pessoas);
	for (int i = 0; i<pessoas; i++) {
		System.out.printf("Paciente: %S", nome[i]);
		System.out.printf("\nIdade: %d\n", idade[i]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	teclado.close();
}
}