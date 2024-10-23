package jogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static Random random = new Random();

	public static void main(String[] args) {
		ArrayList<Castelo> castelo = new ArrayList<Castelo>();
		ArrayList<String> jogadores = new ArrayList<String>();

		System.out.println("Trabalho feito por Enzo Sampaio, Vinicius de Souza, Arthur Coutinho\n\n");
		
		criarCastelos(castelo);
		jogadores(jogadores);
	}

	public static void criarCastelos(ArrayList<Castelo> castelos) {
		for (int i = 0; i < 2; i++) {
			Japones castelo = new Japones(2, 2, "CJ" + (1 + i), 15);
			castelos.add(castelo);
		}

		for (int i = 0; i < 2; i++) {
			Europeu castelo = new Europeu(2, 3, "CE" + (1 + i), 10);
			castelos.add(castelo);
		}

		for (Castelo castelo : castelos) {
			System.out.println(castelo.situacao());
		}
	}

	public static void jogadores(ArrayList<String> jogadores) {
		System.out.println("Digite o nome do jogador 1 (será o Japão): ");
		jogadores.add(teclado.nextLine());

		System.out.println("Digite o nome do jogador 2 (será a Europa): ");
		jogadores.add(teclado.nextLine());

		System.out.println("Jogador 1: " + jogadores.get(0));
		System.out.println("Jogador 2: " + jogadores.get(1));
	}

	public static Castelo escolherAlvo(ArrayList<Castelo> castelos, Castelo atacante) {
		String alvo;
		Castelo casteloAlvo = null;

		System.out.println("Escolha o castelo alvo para " + atacante.getNome() + " atacar: ");

		while (casteloAlvo == null) {
			alvo = teclado.nextLine();

			for (Castelo castelo : castelos) {
				if (castelo.getNome().equalsIgnoreCase(alvo) && !castelo.getNome().equalsIgnoreCase(atacante.getNome())
						&& !mesmoTipo(atacante, castelo)) {
					casteloAlvo = castelo;
					break;
				}
			}

			if (casteloAlvo == null) {
				System.out.println("Castelo inválido, é do mesmo tipo ou é o próprio atacante. Tente novamente.");
			}
		}

		return casteloAlvo;
	}

	public static boolean mesmoTipo(Castelo atacante, Castelo alvo) {
		return atacante.getClass().equals(alvo.getClass());
	}

	private static boolean verificarTermino(ArrayList<Castelo> castelos) {
		boolean existeJapones = false;
		boolean existeEuropeu = false;

		for (Castelo castelo : castelos) {
			if (castelo instanceof Japones) {
				existeJapones = true;
			} else if (castelo instanceof Europeu) {
				existeEuropeu = true;
			}
		}

		if (!existeJapones) {
			System.out.println("TODOS OS CASTELOS JAPONESES FORAM DESTRUÍDOS!");
			System.out.println("CASTELO EUROPEU VENCEDOR!");
			return true;
		}
		if (!existeEuropeu) {
			System.out.println("TODOS OS CASTELOS EUROPEUS FORAM DESTRUÍDOS!");
			System.out.println("CASTELO JAPONES VENCEDOR!");
			return true;
		}

		return false;
	}

	

}
