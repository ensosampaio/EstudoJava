package simplesmente;

import dados.Item;

public class Testar_ativ2_questao07 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();//criou uma lista vazia
		
		lista.inserirUltimo(new Item(10));//inventa os valores
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(7));
		lista.inserirUltimo(new Item(2));
		
		System.out.println("lista criada:\n"+lista.toString());
		
		int soma = lista.calcularSoma();
		if (soma == 0) {
			System.out.println("a lista está vazia");
		}else {
			System.out.println("a soma é "+soma);
		}
	}

}
