package simplesmente;

import dados.Item;

public class Testar_ativ2_questao09 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(7));
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(5));
		
		System.out.println(lista.procurarPar());
		
		
	}

}
