package duplamente;

import dados.Item;

public class TestarQuestao09 {
	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();

		lista.inserirUltimo(new Item(1));
		lista.inserirUltimo(new Item(1));
		lista.inserirUltimo(new Item(2));
		System.out.println(lista.calcularMedia());

	}
}
