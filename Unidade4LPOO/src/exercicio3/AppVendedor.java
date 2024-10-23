package exercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class AppVendedor {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		cadastrarFuncionario(funcionarios);
		System.out.println("Folha salarial: " + folhaSalarial(funcionarios) );
		
	
	}

	public static void cadastrarFuncionario(ArrayList<Funcionario> funcionarios) {

		System.out.println("Digite o salário base do gerente: ");
		double salarioGerente = Double.parseDouble(teclado.nextLine());

		Gerente.setSalario_base(salarioGerente);

		Gerente gerente = new Gerente("Caio", 1);

		funcionarios.add(gerente);

		System.out.println("Digite o salário base do assistente: ");
		double salarioAssistente1 = Double.parseDouble(teclado.nextLine());

		Assistente.setSalario_base(salarioAssistente1);

		Assistente assistente = new Assistente("Enzo", 1);

		funcionarios.add(assistente);

		System.out.println("Digite o salário do vendedor: ");
		double salarioVendedor = Double.parseDouble(teclado.nextLine());

		System.out.println("Digite a comissão do vendedor: ");
		double comissão = Double.parseDouble(teclado.nextLine());

		Vendedor.setSalario_base(salarioVendedor);

		Vendedor vendedor = new Vendedor("Valentina", 1, comissão);

		funcionarios.add(vendedor);

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.situacao());
		}
	}

	
	public static double folhaSalarial(ArrayList<Funcionario> funcionarios) {
		double soma = 0;
		for (Funcionario f : funcionarios) {
			soma+= f.calcularSalario();
		}
		return soma;
		
	}




}
