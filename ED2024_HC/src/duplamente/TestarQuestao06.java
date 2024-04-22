package duplamente;

import dados.Item;

public class TestarQuestao06 {

	public static void main(String[] args) {
		ListaDupla lista1 = new ListaDupla();
		ListaDupla lista2 = new ListaDupla();
		
		lista1.inserirUltimo(new Item(10));
		lista1.inserirUltimo(new Item(20));
		lista1.inserirUltimo(new Item(30));

		lista2.inserirUltimo(new Item(40));
		lista2.inserirUltimo(new Item(50));
		
		lista1.concatenarListas(lista2);
		
		System.out.println("lista1:\n"+lista1.toString());
		System.out.println("lista2:\n"+lista2.toString());
	
	}

}
