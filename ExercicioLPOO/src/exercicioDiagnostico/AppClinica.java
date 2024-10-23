package exercicioDiagnostico;

import java.util.Scanner;

public class AppClinica {
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Digite quantos pacientes podem ser registrados");
		int tamanho = Integer.parseInt(teclado.nextLine());
		
		VetPaciente vetpaciente = new VetPaciente(tamanho);
	
		int opcao;
		
		do {
			System.out.println("1- Cadastrar" + "\n2- Consultar"+ "\n3- Imprimir Cadastro"+ "\n4 - Sair");
			opcao = Integer.parseInt(teclado.nextLine());
			switch (opcao) {
			case 1:
				cadastrarPaciente(vetpaciente);
				break;
			case 2:
				consultarCPF(vetpaciente);
				break;
			case 3:
				System.out.println(vetpaciente);
				break;
			case 4:
				System.out.println("Fim do Programa!");
				break;
			default:
				System.out.println("Opção inválida");
			}
		}
		while (opcao !=4);
	
	
	}

	public static void cadastrarPaciente(VetPaciente a) {
		Paciente paciente = new Paciente();
		
		System.out.println("Digite o nome do paciente: ");
		String nome = teclado.nextLine();
		
		System.out.println("Digite o CPF do paciente: ");
		String cpf = teclado.nextLine();
		
		System.out.println("Digite a data de nascimento do paciente: ");
		String data = teclado.nextLine();
		
		System.out.println("Digite o histórico do paciente: ");
		String historico = teclado.nextLine();
		
		paciente.setNome(nome);
		paciente.setCPF(cpf);
		paciente.setDataNascimento(data);
		paciente.setHistorico(historico);
		
		int resultado = a.inserirPaciente(paciente);
		switch (resultado) {
		case 0:
			System.out.println("Paciente cadastrado com sucesso");
			break;
		case -1:
			System.out.println("Erro: Não há espaço para mais pacientes.");
			break;
		case -2:
			System.out.println("Erro: Já existe um paciente com esse CPF");
			break;
		}
	
	}

	public static void consultarCPF(VetPaciente a) {
		System.out.println("Digite o CPF que voce deseja consultar: ");
		String CPF = teclado.nextLine();
		
		int posicao = a.pesquisa(CPF);
		if (posicao != -1) {
			Paciente paciente = a.getPaciente(posicao);
			System.out.println("Paciente encontrado: ");
			System.out.println(paciente);
		}else {
			System.out.println("Paciente não encontrado");
		}
	}








}

