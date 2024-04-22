package duplamente;

import dados.Item;

public class TestarQuestao08 {
	public static void main(String[] args) {

		ListaDupla lista = new ListaDupla();

		lista.inserirUltimo(new Item(1));
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(6));
		lista.inserirUltimo(new Item(7));
		lista.inserirUltimo(new Item(0));
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(11));

		lista.acharMaior();
		System.out.println(lista.acharMaior());

	}
}
