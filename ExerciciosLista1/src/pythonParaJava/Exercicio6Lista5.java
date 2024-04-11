package pythonParaJava;
import java.util.Scanner;


public class Exercicio6Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite a nota do trabalho: ");
	double notaTrabalho = teclado.nextDouble();
	
	System.out.print("Digite a nota da prova: ");
	double notaProva = teclado.nextDouble();
	
	double notaTotal = (notaTrabalho + notaProva)/2;
	
	if (notaTotal>=7) {
		System.out.println("\nO aluno está aprovado");
	}
	else {
		System.out.println("\nO aluno está reprovado");
	}
	
	System.out.println("A nota total do aluno foi: "+notaTotal);
	
	teclado.close();
}
}
