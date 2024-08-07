package arrays;

import java.util.Arrays;

public class Exercicio {
	public static void main(String[] args) {

		double[] notasAlunoA = new double[4];
		System.out.println(Arrays.toString(notasAlunoA));
		notasAlunoA[0] = 7.8;
		notasAlunoA[1] = 10;
		notasAlunoA[2] = 9;
		notasAlunoA[3] = 9;
		System.out.println(Arrays.toString(notasAlunoA));
	
		double total = 0;
		for (int i = 0; i<notasAlunoA.length; i++ ) {
			total += notasAlunoA[i];
		}
	System.out.println(total/4);
	
	}
}
