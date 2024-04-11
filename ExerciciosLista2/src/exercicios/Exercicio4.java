package exercicios;

import java.util.Scanner;

public class Exercicio4 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite seu salário: ");
	double salario = teclado.nextDouble();
	
	System.out.print("Digite o código do cargo: ");
	int codigo = teclado.nextInt();
	
	switch (codigo) {
		case(101):
			
			double salarioGerente = salario + (salario*0.1);
			System.out.printf("O seu novo salário será %.2f, seu antigo salário era %.2f, e a diferença é %.2f", salarioGerente, salario, (salarioGerente-salario));
			break;
	
		case(102):	
			
			double salarioEngenheiro = salario + (salario*0.2);
			System.out.printf("O seu novo salário será %.2f, seu antigo salário era %.2f, e a diferença é %.2f", salarioEngenheiro, salario, (salarioEngenheiro - salario));
			break;
	
		case(103):
			
			double salarioTecnico = salario + (salario*0.3);
			System.out.printf("O seu novo salário será %.2f, seu antigo salário era %.2f, e a diferença é %.2f", salarioTecnico, salario, (salarioTecnico - salario));
			break;
		
		default:
			double salarioNovo = salario + (salario*0.05);
			System.out.printf("O seu novo salário será %.2f, seu antigo salário era %.2f, e a diferença é %.2f", salarioNovo, salario, (salarioNovo - salario));
	}	
	teclado.close();
	
	System.out.println("\nFim do programa");
}
}
