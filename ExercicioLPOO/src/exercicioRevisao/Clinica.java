package exercicioRevisao;

import java.util.ArrayList;
import java.util.Scanner;

public class Clinica {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		int opcao;

		do {
			System.out.println("1- Cadastrar");
			System.out.println("2- Conferir Nome");
			System.out.println("3- Imprimir todos");
			System.out.println("4- Sair");

			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarCliente(pacientes);
				break;
			case 2:
				procurarCliente(pacientes);
				break;
			case 3:
				imprimirClientes(pacientes);
				break;
			}

		} while (opcao != 4);

	}

	public static void cadastrarCliente(ArrayList<Paciente> pacientes) {

		for (int i = 0; i < 5; i++) {
			Paciente paciente = new Paciente();

			System.out.println("Digite o nome: ");
			String nome = teclado.nextLine();

			System.out.println("Digite o cpf: ");
			String cpf = teclado.nextLine();

			System.out.println("Digite a data: ");
			String data = teclado.nextLine();

			paciente.setNome(nome);
			paciente.setCpf(cpf);
			paciente.setDataNasc(data);

			pacientes.add(paciente);
		}

	}

	public static void procurarCliente(ArrayList<Paciente> pacientes) {
		System.out.println("Digite um nome: ");
		String nome = teclado.nextLine();

		for (int i = 0; i < pacientes.size(); i++) {
			if (!pacientes.get(i).getNome().equalsIgnoreCase(nome)) {
				System.out.println("Paciente não encontrado!");
			} else {
				System.out.println(
						"Paciente: " + pacientes.get(i).getNome() + "\nHistórico: " + pacientes.get(i).getHistorico());
			}
		}

	}

	public static void imprimirClientes(ArrayList<Paciente> pacientes) {
		for (int i = 0; i < pacientes.size(); i++) {
			System.out.println(pacientes.get(i));
		}
	}

}
