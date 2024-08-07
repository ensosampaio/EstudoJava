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

public class Exercicio03 {
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
		        int idade1 = Integer.parseInt(o1.split("Idade: ")[1]);
		        int idade2 = Integer.parseInt(o2.split("Idade: ")[1]);
		        return Integer.compare(idade1, idade2);
		    }
		});

		try {
			BufferedWriter escrever = new BufferedWriter(new FileWriter("pessoasOrganizadasPorIdadeExercicio03.txt"));
			for (String linha : pessoas) {
				escrever.write("\n" + linha);
			}
			escrever.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			BufferedReader ler = new BufferedReader(new FileReader("pessoasOrganizadasPorIdadeExercicio03.txt"));
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