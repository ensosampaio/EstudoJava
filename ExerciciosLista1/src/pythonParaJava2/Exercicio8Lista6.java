package pythonParaJava2;

import java.util.Scanner;

public class Exercicio8Lista6 {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	int candidato1 = 0;
	int candidato2 = 0;
	int candidato3 = 0;
	int votobranco = 0;
	int votonulo = 0;
	int voto;
	int contador = 0;

	System.out.println("Digite o numero do candidato (1, 2 ou 3), 4 para voto nulo e 0 para voto em branco");
	
	while ((voto = teclado.nextInt())!=-1) {
		switch (voto) {
		case 1:
			candidato1++;
			contador++;
			break;
		case 2:
			candidato2++;
			contador++;
			break;
		case 3:
			candidato3++;
			contador++;
			break;
		case 4:
			votonulo++;
			contador++;
			break;
		case 0:
			votobranco++;
			contador++;
			break;
			}
	
	
	}	
	System.out.printf("O numero de votos para o candidato 1 foi: %d\n", candidato1);
	System.out.printf("O numero de votos para o candidato 2 foi: %d\n", candidato2);
	System.out.printf("O numero de votos para o candidato 3 foi: %d\n", candidato3);
	System.out.printf("O numero de votos nulos foi: %d\n", votonulo);
	System.out.printf("O numero de votos em branco foi: %d\n", votobranco);
	System.out.printf("O total de votos foi: %d\n", contador);
	
	int maxVotos = Math.max(candidato1, Math.max(candidato2, candidato3));
	
	if (candidato1 == maxVotos) {
		System.out.printf("O vencedor foi o candidato 1 com %d votos", candidato1);
	}
	if (candidato2 == maxVotos) {
		System.out.printf("O vencedor foi o candidato 2 com %d votos", candidato2);
	}
	if (candidato3 == maxVotos) {
		System.out.printf("O vencedor foi o candidato 3 com %d votos\n", candidato3);
	}
	
	System.out.println("\nObrigado por votar");
	

	
	teclado.close();
}
}
