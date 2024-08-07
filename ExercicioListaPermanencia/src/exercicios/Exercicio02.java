package exercicios;

import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;

public class Exercicio02 {
	public static void main(String[] args) {

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

		List<String> pessoas = new ArrayList<>();

		try {
			BufferedReader ler = new BufferedReader(new FileReader("output.txt"));
			String linha;
			try {
				while ((linha = ler.readLine()) != null) {
					pessoas.add(linha);

				}
				ler.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Collections.sort(pessoas, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String nome1 = o1.split(" ")[0];
				String nome2 = o2.split(" ")[0];
				return nome1.compareTo(nome2);
			}
		});
		try {
			BufferedWriter escrever = new BufferedWriter(new FileWriter("pessoasOrganizadasPorNomeExercicio2.txt"));
			for (String linha : pessoas) {
				escrever.write("\n" + linha);
			}
			escrever.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			BufferedReader ler = new BufferedReader(new FileReader("pessoasOrganizadasPorNomeExercicio2.txt"));
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