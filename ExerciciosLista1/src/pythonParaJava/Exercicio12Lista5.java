package pythonParaJava;
import java.util.Scanner;


public class Exercicio12Lista5 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Digite o lado A do triangulo: ");
	double ladoA = teclado.nextDouble();
	
	System.out.print("Digite o lado B do triangulo: ");
	double ladoB = teclado.nextDouble();
	
	System.out.print("Digite o lado C do triangulo: ");
	double ladoC = teclado.nextDouble();
	
	
	if (ladoA == 0 || ladoB == 0 || ladoC == 0) {
		System.out.println("É um triangulo impossivel");
	}
	else if (ladoA>ladoB+ladoC || ladoB>ladoA+ladoC || ladoC>ladoA+ladoB) {
		System.out.println("É um triangulo impossivel");
	}
	else if (ladoA==ladoB && ladoA == ladoC && ladoB==ladoC) {
		System.out.println("É Équilátero");
	}
	else if (ladoA==ladoB || ladoB==ladoC || ladoA==ladoC) {
		System.out.println("É Isósceles");
	}
	else {
		System.out.println("É Escaleno");
	}
	
	
	
	
	teclado.close();
}
}
