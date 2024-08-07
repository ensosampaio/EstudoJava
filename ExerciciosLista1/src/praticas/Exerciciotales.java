package praticas;

import java.util.Scanner;

public class Exerciciotales {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite quantos cigarros voce fuma diariamente: ");
		double cigarros = Integer.parseInt(teclado.nextLine());
		
		System.out.print("Digite a quantos anos voce fuma: ");
		double tempo = Integer.parseInt(teclado.nextLine());
		
		double conversorAnoDia = (tempo*365);
		
		double total = cigarros*10*conversorAnoDia*24*60;
		double totalDias = total/1440;
		
		System.out.printf("Voce perdeu %.2f dias de vida fumando", totalDias);
		
		
		
		teclado.close();
	}
}
