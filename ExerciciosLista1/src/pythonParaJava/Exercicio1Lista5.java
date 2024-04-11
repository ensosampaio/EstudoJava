package pythonParaJava;
import java.util.Scanner;

public class Exercicio1Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite sua idade: ");
	int idade = teclado.nextInt();
	
	if (idade>=10 && idade<=18) {
		System.out.println("Sua idade está no intervalo");
	}
	else {
		System.out.println("Sua idade nao está no intervalo");
	}
	
	
	
	teclado.close();
}
}
