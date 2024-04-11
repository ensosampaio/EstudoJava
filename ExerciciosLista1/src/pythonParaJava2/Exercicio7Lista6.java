package pythonParaJava2;
import java.util.Scanner;



public class Exercicio7Lista6 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	int totalPositivo = 0;
	int soma = 0;
	int numero;
	int contador = 0;
	int perceNegativo = 0;
	
	
	
	System.out.println("Digite um numero inteiro ou digite zero para sair");
	
	while((numero = teclado.nextInt())!=0) {
		soma = soma+numero;
		contador +=1;
		if (contador == 0) {
			System.out.println("Não foi digitado nenhum numero válido");
		}
		
		if (numero>0) {
			totalPositivo+=1;
		}
	}
	if (contador!=0) {
		double media = soma/contador;
		System.out.printf("A média é %.1f\n", media);
		System.out.printf("Tem %d numeros positivos\n", totalPositivo);
		perceNegativo = 100 - ((totalPositivo*100)/contador);
		System.out.printf("Tem %d porcento de numeros negativos\n", perceNegativo);
	}
	else {
		System.out.println("Não foi digitado nenhum numero válido");
	}
	teclado.close();	
}
}
