package pythonParaJava2;

import java.util.Scanner;

public class Exercicio9Lista6 {
public static void main(String[] args) {
	Scanner teclado =  new Scanner (System.in);
	
	int peixe;
	int contador = 0;
	double pesoLimite; 
	double pesoTotal = 0;
	System.out.print("Digite o peso total do dia: \n");
	pesoLimite = teclado.nextDouble();
	
	
	
	System.out.println("Digite o peso do peixe: \n");
	while ((peixe = teclado.nextInt())!=0 || pesoTotal>pesoLimite) {
		if (peixe!=0) {
			contador++;
			pesoTotal += peixe;
			System.out.printf("O peso total foi de %.1f", pesoTotal);
			System.out.println("Digite o peso do peixe:");
			
			if (pesoTotal>pesoLimite) {
				double pesoExcedido = pesoTotal - pesoLimite;
				System.out.printf("Voce excedeu a cota do peso diário por: %.2f", pesoExcedido);
				peixe-=1;
				pesoTotal = peixe;
			}
		}
		
	}
	System.out.printf("O total de kg pescado foram: %.2f",pesoTotal);
	
	
	
	
	
	teclado.close();
}
}
