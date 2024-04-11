package exercicios;

import java.util.Scanner;

public class Exercicio3Lista1 {
public static void main(String[] args) {
	Scanner teclado =  new Scanner(System.in);
	
	System.out.print("Digite seu nome: ");
	String nome = teclado.nextLine();
	
	System.out.print("Digite a kilometragem percorrida: ");
	double km = teclado.nextDouble();
	
	System.out.print("Digite o tempo da corrida (em horas): ");
	double tempo = teclado.nextDouble();
	
	double media = km/tempo;
	
	System.out.printf("A velocidade média de %S foi de %.2f km/h",nome, media);
	
	
	
	
	
	
	
	
	
	teclado.close();
}
	
}
