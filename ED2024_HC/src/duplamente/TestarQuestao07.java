package duplamente;

import dados.Item;

public class TestarQuestao07 {

	public static void main(String[] args) {
		ListaDupla lista1 = new ListaDupla();
		ListaDupla lista2 = new ListaDupla();
		
		lista1.inserirUltimo(new Item(1));
		lista1.inserirUltimo(new Item(2));
		lista1.inserirUltimo(new Item(3));
		lista1.inserirUltimo(new Item(4));
		lista1.inserirUltimo(new Item(5));

		
		lista2 = lista1.partirLista();
		
		System.out.println("lista1:\n"+lista1.toString());
		System.out.println("lista2:\n"+lista2.toString());
		System.out.println("lista1:\n"+lista1.getQuantNos());
		System.out.println("lista2:\n"+lista2.getQuantNos());
		
		
	}

}
