package exercicios;

public class Exercicio06 {
	public static void main(String[] args) {

		int matriz[][] = { { 1, 2, 3 }, { 4, 5, 6 } };

		System.out.println("A média dos elementos da matriz é: " + calcularMediaMatriz(matriz));

	}

	public static double calcularMediaMatriz(int matriz[][]) {
		double somador = 0;
		double total = 0;
		double media = 0;

		for (int r = 0; r < matriz.length; r++) {
			for (int c = 0; c < matriz[r].length; c++) {

				somador += matriz[r][c];
				total++;
			}
		}

		if (total == 0) {
			return 0;
		} else {
			media = somador / total;
			return media;
		}

	}

}
