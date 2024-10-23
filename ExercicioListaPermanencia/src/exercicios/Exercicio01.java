package exercicios;

import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;

public class Exercicio01 {
	public static void main(String[] args) {

		String[] primeiroNome = { "Helena", "Alice", "Laura", "Maria", "Sophia", "Manuela", "Maitê", "Liz", "Cecilia",
				"Isabela", "Luísa", "Eloá", "Júlia", "Ayla", "Aurora", "Valentina", "Isis", "Antonella", "Maya",
				"Leticia"};

		String[] sobrenome = { "Silva", "Santos", "Lima", "Pimentel", "Sampaio", "Lopes", "Herzog", "Azeredo", "Soares",
				"Assis", "Machado", "Pereira", "Bianchi", "Gobbi", "Schneider", "Pera", "Castro", "Alves", "Brigatto",
				"Scarpatti", };

		String[] endereco = { "Avenida Rio Branco", "Santa Lúcia", "Bairro da Penha", "Bento Ferreira" };

		String[] estadoCivil = { "S", "C", "V", "D" };

		String[] sexo = {"F"};

		String[] profissao = { "Médica", "Advogada", "Professora", "Engenheira", "Programadora" };

		String[] complemento = { "Casa", "Apartamento" };

		String[] bairro = { "Praia do Canto", "Jardim da Penha" };

		String[] uf = { "ES" };

		String[] cidade = { "Vitória" };

		Random gerador = new Random();

		try {
			BufferedWriter escrever = new BufferedWriter(new FileWriter("output.txt", true));

			int numerosAleatorios = 100;

			for (int i = 0; i < numerosAleatorios; i++) {
				String Nome = primeiroNome[gerador.nextInt(primeiroNome.length)];
				String Sobrenome = sobrenome[gerador.nextInt(sobrenome.length)];

				String email = gerarEmail(Nome, Sobrenome);

				String linha = (gerador.nextInt(100000) + 1) + "; " + Nome + " " + Sobrenome + "; " + gerarCPF() + "; "
						+ gerarRG() + "; " + (gerador.nextInt(50) + 1) + "; " + gerarCEP() + "; "
						+ endereco[gerador.nextInt(endereco.length)] + "; "
						+ estadoCivil[gerador.nextInt(estadoCivil.length)] + "; " + gerarDataNascimento() + "; "
						+ (gerador.nextInt(1200) + 1) + "; " + sexo[gerador.nextInt(sexo.length)] + "; "
						+ profissao[gerador.nextInt(profissao.length)] + "; "
						+ complemento[gerador.nextInt(complemento.length)] + "; "
						+ bairro[gerador.nextInt(bairro.length)] + "; " + uf[gerador.nextInt(uf.length)] + "; "
						+ cidade[gerador.nextInt(cidade.length)] + "; " + gerarTelefoneFixo() + "; " + gerarCelular()
						+ "; " + email + "; " + gerarDataRegistro() + "\n";

				escrever.write(linha);
			}

			escrever.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			BufferedReader ler = new BufferedReader(new FileReader("output.txt"));
			String linha;
			while ((linha = ler.readLine()) != null) {
				System.out.println(linha);
			}
			ler.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String gerarCPF() {
		Random random = new Random();
		int[] cpf = new int[11];

		for (int i = 0; i < 9; i++) {
			cpf[i] = random.nextInt(10);
		}

		cpf[9] = calcularDigito(cpf, 10);

		cpf[10] = calcularDigito(cpf, 11);

		return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", cpf[0], cpf[1], cpf[2], cpf[3], cpf[4], cpf[5], cpf[6],
				cpf[7], cpf[8], cpf[9], cpf[10]);
	}

	private static int calcularDigito(int[] cpf, int pesoInicial) {
		int soma = 0;
		for (int i = 0; i < pesoInicial - 1; i++) {
			soma += cpf[i] * (pesoInicial - i);
		}
		int resto = soma % 11;
		return resto < 2 ? 0 : 11 - resto;
	}

	public static String gerarRG() {
		Random random = new Random();
		int[] rg = new int[9];

		for (int i = 0; i < 8; i++) {
			rg[i] = random.nextInt(10);
		}

		rg[8] = random.nextInt(10);

		return String.format("%d.%d%d%d.%d%d%d-%d", rg[0], rg[1], rg[2], rg[3], rg[4], rg[5], rg[6], rg[7], rg[8]);
	}

	public static String gerarDataNascimento() {
		// Define o intervalo de anos para a data de nascimento
		int minYear = 1970;
		int maxYear = 2005;

		// Gera uma data aleatória
		long minDay = LocalDate.of(minYear, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(maxYear, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

		// Converte o dia aleatório para uma data
		LocalDate dataNascimento = LocalDate.ofEpochDay(randomDay);

		// Formata a data no padrão dd/MM/yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataNascimento.format(formatter);
	}

	public static String gerarCEP() {
		Random random = new Random();

		// Gerando os 5 primeiros dígitos
		int parte1 = random.nextInt(90000) + 10000; // Garante 5 dígitos (10000 a 99999)

		// Gerando os 3 últimos dígitos
		int parte2 = random.nextInt(900) + 100; // Garante 3 dígitos (100 a 999)

		// Formatando o CEP no padrão XXXXX-XXX
		return String.format("%05d-%03d", parte1, parte2);
	}

	public static String gerarTelefoneFixo() {
		Random random = new Random();

		int parte1 = 3;
		int parte2 = random.nextInt(9000000) + 1000000;

		return String.format("(27) %d%07d", parte1, parte2);
	}

	public static String gerarCelular() {
		Random random = new Random();

		int parte1 = 9;
		int parte2 = random.nextInt(90000000) + 10000000;

		return String.format("(27) %d%08d", parte1, parte2);
	}

	public static String gerarEmail(String primeiroNome, String sobrenome) {
		Random random = new Random();

		// Definindo um domínio de e-mail comum
		String[] dominios = { "example.com", "email.com", "mail.com", "webmail.com" };
		String dominio = dominios[random.nextInt(dominios.length)];

		// Adicionando um número aleatório para garantir unicidade
		int numeroAleatorio = random.nextInt(1000);

		// Formatando o e-mail no formato: primeiroNome.sobrenome###@dominio.com
		return String.format("%s.%s%d@%s", primeiroNome.toLowerCase(), sobrenome.toLowerCase(), numeroAleatorio,
				dominio);
	}

	public static String gerarDataRegistro() {
	    // Define o intervalo de anos para a data de registro
	    LocalDate inicio = LocalDate.of(2020, 1, 1);
	    LocalDate fim = LocalDate.of(2024, 12, 31);
	    
	    // Gera um número aleatório de dias entre a data de início e fim
	    long diasEntre = ThreadLocalRandom.current().nextLong(0, inicio.until(fim).toTotalMonths() * 30);
	    LocalDate dataRegistro = inicio.plusDays(diasEntre);
	    
	    // Formata a data no padrão dd/MM/yyyy
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return dataRegistro.format(formatter);
	}



}
