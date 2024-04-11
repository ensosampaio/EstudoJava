package simplesmente;

import dados.Item;

public class Testar_ativ2_questao08 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(10));
		
		double media = lista.calcularMedia();
		if (media == 0) {
			System.out.println("lista vazia");
		}else {
			System.out.println("a media é "+media);
		}
		
		
		

	}

}
