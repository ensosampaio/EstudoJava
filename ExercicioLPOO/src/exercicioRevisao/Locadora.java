package exercicioRevisao;

import java.util.LinkedList;
import java.util.Scanner;

public class Locadora {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		LinkedList<Carro> carro = new LinkedList<Carro>();

		int opcao;
		do {
			System.out.println("1- Cadastrar carro");
			System.out.println("2- Devolver carro");
			System.out.println("3- Locar carro");
			System.out.println("4- Mostrar carros");
			System.out.println("5- Sair");
			System.out.println("Opção selecionada: ");

			opcao = Integer.parseInt(teclado.nextLine());

			switch (opcao) {
			case 1:
				cadastrarCarro(carro);
				break;
			case 2:
				devolverCarro(carro);
				break;
			case 3:
				locarCarro(carro);
				break;
			case 4:
				mostrarCarros(carro);
				break;
			}

		} while (opcao != 5);

	}

	public static void cadastrarCarro(LinkedList<Carro> carros) {
		int codigo;
		String modelo;
		
		for (int i = 0; i<5; i++) {
			Carro carro = new Carro();
			
			System.out.println("Código: ");
			codigo = Integer.parseInt(teclado.nextLine());
		
			System.out.println("Modelo: ");
			modelo = teclado.nextLine();
			
			carro.setCodigo(codigo);
			carro.setModelo(modelo);
			carros.add(carro);
		}
		
		System.out.println("Carros cadastrados com sucesso!");

	}

	public static void mostrarCarros(LinkedList<Carro> carros) {
		for (int i = 0; i < carros.size(); i++) {
			System.out.println(carros.get(i));
		}
	}

	public static int pesquisar(LinkedList<Carro> carro) {

		System.out.println("Digite o código do carro: ");
		int codigo = Integer.parseInt(teclado.nextLine());

		for (int i = 0; i < carro.size(); i++) {
			if (codigo == carro.get(i).getCodigo()) {
				return i;
			}
		}
		return -1;

	}


	public static void locarCarro(LinkedList<Carro> carro) {
	
		int pos = pesquisar(carro);
		
		if(pos == -1) {
			System.out.println("Carro não existe");
		} else if (carro.get(pos).locar()) {
			System.out.println("Carro locado com sucesso\n Carros locados: "+ Carro.getNumLocados());
		} else {
			System.out.println("CARRO ESTÁ LOCADO!");
		}
	
	}
	
	public static void devolverCarro(LinkedList<Carro> carro) {
		
		int pos = pesquisar(carro);
		
		if(pos == -1) {
			System.out.println("Carro não existe");
		} else if (carro.get(pos).devolver()) {
			System.out.println("Carro devolvido com sucesso\n Carros locados: "+ Carro.getNumLocados());
		} else {
			System.out.println("CARRO NÃO ESTÁ LOCADO!");
		}
	
	}






}
