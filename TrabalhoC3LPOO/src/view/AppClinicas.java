package view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import control.ClinicaHospitalarController;
import control.ClinicaOdontologicaController;
import control.PacienteController;
import model.ClinicaHospitalar;
import model.Paciente;
import model.ClinicaOdontologica;

public class AppClinicas {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String arquivoPaciente = "Paciente.txt";
		String arquivoHospital = "Hospital.txt";
		String arquivoOdontologia = "Odontologia.txt";
	

		try {
			criarArquivo(arquivoPaciente);
			criarArquivo(arquivoHospital);
			criarArquivo(arquivoOdontologia);
		} catch (IOException e) {
			System.err.println("Erro ao criar arquivo! " + e.getMessage());
			return;
		}
		
		PacienteController controlePaciente = new PacienteController("Paciente.txt");
		ClinicaHospitalarController controleHospital = new ClinicaHospitalarController("Hospital.txt");
		ClinicaOdontologicaController controleOdontologico = new ClinicaOdontologicaController("Odontologia.txt");

		int opcao;
		do {
			mostrarMenuPrincipal();
			opcao = Integer.parseInt(teclado.nextLine());
			switch (opcao) {
			case 1:
				menuPaciente(controlePaciente);
				break;
			case 2:
				menuHospital(controleHospital);
				break;
			case 3:
				menuClinicaOdontologica(controleOdontologico);
				break;
			case -1:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != -1);

		teclado.close();
	}

	// Métodos de paciente
	public static void cadastrarPaciente(PacienteController controle) {
		System.out.println("Digite o nome do paciente: ");
		String nome = teclado.nextLine();

		System.out.println("Digite a idade do paciente: ");
		int idade = lerIdade();

		System.out.println("Digite o CPF: ");
		String CPF = teclado.nextLine();

		System.out.println("Digite o historico prévio do paciente: ");
		String historico = teclado.nextLine();

		System.out.println("Digite o endereço do paciente: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite o telefone do paciente: ");
		String telefone = teclado.nextLine();

		Paciente paciente = new Paciente(nome, idade, CPF, historico, endereco, telefone);

		controle.cadastrar(paciente);
		System.out.println("Paciente cadastrado com sucesso!");
	}

	public static void deletarPaciente(PacienteController controle) {
		System.out.println("Digite o CPF do paciente para deletar: ");
		String CPF = teclado.nextLine();

		if (controle.deletar(CPF)) {
			System.out.println("Paciente deletado com sucesso!");
		} else {
			System.out.println("Paciente não encontrado!");
		}
	}

	public static void mostrarPacientes(PacienteController controle) {
		System.out.println(controle.getPaciente());
	}

	public static void atualizarPaciente(PacienteController controle) {
		System.out.println("Digite o CPF do paciente que deseja atualizar: ");
		String CPF = teclado.nextLine();

		Paciente paciente = controle.procurarPorCpf(CPF);
		if (paciente == null) {
			System.out.println("Paciente com CPF " + CPF + " não encontrado.");
			return;
		}

		System.out.println("Digite o novo nome do paciente: ");
		String nome = teclado.nextLine();

		System.out.println("Digite a nova idade do paciente: ");
		int idade = lerIdade();

		System.out.println("Digite o novo histórico do paciente: ");
		String historico = teclado.nextLine();

		System.out.println("Digite o novo endereço do paciente: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite o novo telefone do paciente: ");
		String telefone = teclado.nextLine();

		String resultado = controle.atualizarPaciente(nome, idade, CPF, historico, endereco, telefone);
		System.out.println(resultado);
	}

	// Métodos de hospital
	public static void cadastrarHospital(ClinicaHospitalarController controle) {
		System.out.println("Digite o nome do hospital: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o CNPJ do hospital: ");
		String cnpj = teclado.nextLine();

		System.out.println("Digite o endereço do hospital: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite o telefone do hospital: ");
		String telefone = teclado.nextLine();

		System.out.println("Digite a especialidade do hospital: ");
		String especialidade = teclado.nextLine();

		ClinicaHospitalar hospital = new ClinicaHospitalar(nome, cnpj, endereco, telefone, especialidade);

		controle.cadastrarHospitais(hospital);
		System.out.println("Hospital cadastrado com sucesso!");
	}

	public static void deletarHospital(ClinicaHospitalarController controle) {
		System.out.println("Digite o CNPJ do hospital que deseja deletar: ");
		String cnpj = teclado.nextLine();

		if (controle.removerClinica(cnpj)) {
			System.out.println("Hospital deletado com sucesso!");
		} else {
			System.out.println("Hospital não encontrado!");
		}
	}

	public static void mostrarHospitais(ClinicaHospitalarController controle) {
		System.out.println(controle.getHospital());
	}

	public static void atualizarHospital(ClinicaHospitalarController controle) {
		System.out.println("Digite o CNPJ do hospital para atualizar: ");
		String cnpj = teclado.nextLine();

		System.out.println("Digite o novo nome do hospital: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o novo endereco do hospital: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite o novo telefone do hospital: ");
		String telefone = teclado.nextLine();

		System.out.println("Digite a nova especialidade do hospital: ");
		String especialidade = teclado.nextLine();

		String resultado = controle.atualizarHospital(cnpj, nome, endereco, telefone, especialidade);
		System.out.println(resultado);
	}

	// Métodos de clínica odontológica
	public static void cadastrarOdontologia(ClinicaOdontologicaController controle) {
		System.out.println("Digite o nome da clinica: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o CNPJ da clinica: ");
		String cnpj = teclado.nextLine();

		System.out.println("Digite o endereço da clinica: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite o telefone da clinica: ");
		String telefone = teclado.nextLine();

		System.out.println("Digite a especialidade da clinica: ");
		String especialidade = teclado.nextLine();

		ClinicaOdontologica clinica = new ClinicaOdontologica(nome, cnpj, endereco, telefone, especialidade);

		controle.cadastrarClinicaOdontologica(clinica);
		System.out.println("Clínica odontológica cadastrada com sucesso!");
	}

	public static void deletarOdontologia(ClinicaOdontologicaController controle) {
		System.out.println("Digite o CNPJ da clinica que deseja deletar: ");
		String cnpj = teclado.nextLine();

		if (controle.removerClinica(cnpj)) {
			System.out.println("Clínica odontológica deletada com sucesso!");
		} else {
			System.out.println("Clínica odontológica não encontrada!");
		}
	}

	public static void mostrarClinicasOdontologicas(ClinicaOdontologicaController controle) {
		System.out.println(controle.getOdontologia());

	}

	public static void atualizarClinicaOdontologica(ClinicaOdontologicaController controle) {
		System.out.println("Digite o CNPJ da clinica: ");
		String cnpj = teclado.nextLine();

		System.out.println("Digite o novo nome da clinica: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o novo endereço da clinica: ");
		String endereco = teclado.nextLine();

		System.out.println("Digite o novo telefone da clinica: ");
		String telefone = teclado.nextLine();

		System.out.println("Digite a nova especialidade da clinica: ");
		String especialidade = teclado.nextLine();

		String validacao = controle.atualizarOdontologia(cnpj, nome, endereco, telefone, especialidade);
		System.out.println(validacao);
	}

	private static int lerIdade() {
		int idade = 0;
		boolean idadeValida = false;

		while (!idadeValida) {
			try {
				idade = Integer.parseInt(teclado.nextLine());
				idadeValida = true;
			} catch (NumberFormatException e) {
				System.out.println("ERRO! Digite apenas numeros!");
				System.out.println("Digite a idade do paciente: ");
			}
		}
		return idade;
	}

	private static void mostrarMenuPrincipal() {
		System.out.println("\n--- Menu Principal ---");
		System.out.println("1. Paciente");
		System.out.println("2. Hospital");
		System.out.println("3. Clínica Odontológica");
		System.out.println("-1. Sair");
		System.out.print("Escolha uma opção: ");
	}

	private static void menuPaciente(PacienteController controlePaciente) {
		int opcao;
		do {
			System.out.println("\n--- Menu Paciente ---");
			System.out.println("1. Cadastrar Paciente");
			System.out.println("2. Atualizar Paciente");
			System.out.println("3. Deletar Paciente");
			System.out.println("4. Mostrar Pacientes");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());
			switch (opcao) {
			case 1:
				cadastrarPaciente(controlePaciente);
				break;
			case 2:
				atualizarPaciente(controlePaciente);
				break;
			case 3:
				deletarPaciente(controlePaciente);
				break;
			case 4:
				mostrarPacientes(controlePaciente);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 0);
	}

	private static void menuHospital(ClinicaHospitalarController controleHospital) {
		int opcao;
		do {
			System.out.println("\n--- Menu Hospital ---");
			System.out.println("1. Cadastrar Hospital");
			System.out.println("2. Atualizar Hospital");
			System.out.println("3. Deletar Hospital");
			System.out.println("4. Mostrar Hospitais");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());
			switch (opcao) {
			case 1:
				cadastrarHospital(controleHospital);
				break;
			case 2:
				atualizarHospital(controleHospital);
				break;
			case 3:
				deletarHospital(controleHospital);
				break;
			case 4:
				mostrarHospitais(controleHospital);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 0);
	}

	private static void menuClinicaOdontologica(ClinicaOdontologicaController controleOdontologico) {
		int opcao;
		do {
			System.out.println("\n--- Menu Clínica Odontológica ---");
			System.out.println("1. Cadastrar Clínica Odontológica");
			System.out.println("2. Atualizar Clínica Odontológica");
			System.out.println("3. Deletar Clínica Odontológica");
			System.out.println("4. Mostrar Clínicas Odontológicas");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			opcao = Integer.parseInt(teclado.nextLine());
			switch (opcao) {
			case 1:
				cadastrarOdontologia(controleOdontologico);
				break;
			case 2:
				atualizarClinicaOdontologica(controleOdontologico);
				break;
			case 3:
				deletarOdontologia(controleOdontologico);
				break;
			case 4:
				mostrarClinicasOdontologicas(controleOdontologico);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 0);
	}

	private static void criarArquivo(String arquivo) throws IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			if (file.createNewFile()) {
				System.out.println("Arquivo criado: " + arquivo);
			} else {
				throw new IOException("Erro ao criar arquivo: " + arquivo);
			}
		}
	}




}
