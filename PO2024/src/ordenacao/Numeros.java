package ordenacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Numeros {

	public static void main(String[] args) {
		String filename = "numeros.txt"; // Nome do arquivo a ser gerado
		int quantidade = 100; // Quantidade de números únicos a serem gerados
		int limite = 100; // Limite máximo dos números (0 a 100)

		try {
			generateUniqueNumbersFile(filename, quantidade, limite);
			System.out.println("Arquivo gerado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void generateUniqueNumbersFile(String filename, int quantity, int limit) throws IOException {
		Set<Integer> uniqueNumbers = new HashSet<>();
		Random random = new Random();

		// Gera números únicos
		while (uniqueNumbers.size() < quantity) {
			int number = random.nextInt(limit + 1);
			uniqueNumbers.add(number);
		}

		// Escreve os números no arquivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (Integer number : uniqueNumbers) {
				writer.write(number + "\n");
			}
		}
	}
}