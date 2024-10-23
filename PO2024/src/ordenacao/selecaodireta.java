package ordenacao;

import java.util.Scanner;

import dados.Item;
import jdk.jshell.SourceCodeAnalysis;

public class selecaodireta {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		Scanner scan = new Scanner(System.in);
		//entrada de dados
		for (int i=0; i< 10; i++) {
			System.out.println("Digite um número inteiro: ");
			vetor.inserirDados(new Item(scan.nextInt())) ;
		}
		vetor.selecaoDireta();
		System.out.println("vetor ordenado\n"+vetor.toString());
	}


}
