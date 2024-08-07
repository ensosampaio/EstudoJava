package exercicios;

import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;

public class Exercicio04 {
	public static void main(String[] args) {
		String[] primeiroNome = { "Helena", "Alice", "Laura", "Maria", "Sophia", "Manuela", "Maitê", "Liz", "Cecilia",
				"Isabela", "Luísa", "Eloá", "Júlia", "Ayla", "Aurora", "Valentina", "Isis", "Antonella", "Maya",
				"Leticia", };
		String[] sobrenome = { "Silva", "Santos", "Lima", "Pimentel", "Sampaio", "Lopes", "Herzog", "Azeredo", "Soares",
				"Assis", "Machado", "Pereira", "Bianchi", "Gobbi", "Schneider", "Pera", "Castro", "Alves", "Brigatto",
				"Scarpatti", };

		Random gerador = new Random();
		try {
			BufferedWriter escrever = new BufferedWriter(new FileWriter("outputExercicio4.txt", true));

			int numerosAleatorios = gerador.nextInt(20) + 1;

			for (int i = 0; i < numerosAleatorios; i++) {
				escrever.write(primeiroNome[gerador.nextInt(primeiroNome.length)] + " "
						+ sobrenome[gerador.nextInt(sobrenome.length)] + " Idade: " + (gerador.nextInt(50) + 1)
						+ " Altura: " + (gerador.nextInt(100) + 150) + "cm\n");
			}

			escrever.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			BufferedReader ler = new BufferedReader(new FileReader("outputExercicio4.txt"));
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

}