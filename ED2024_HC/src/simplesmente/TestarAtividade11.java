package simplesmente;

import dados.Item;

public class TestarAtividade11 {
public static void main(String[] args) {
	
	
	ListaSimples lista = new ListaSimples();
	
	lista.inserirUltimo(new Item(10));
	lista.inserirUltimo(new Item(5));
	lista.inserirUltimo(new Item(7));
	lista.inserirUltimo(new Item(50));
	lista.inserirUltimo(new Item(12));
	lista.inserirUltimo(new Item(35));

	double trocar = lista.trocarNumero();
	
	if (trocar == 10) {
		System.out.println("Valor 10 encontrado e alterado pra 50");
	}else {
		System.out.println("Valor 10 não encontrado");
	}

	No atual = lista.getPrim();
	System.out.print(atual.getInfo().getChave() + " ");
	atual = atual.getProx();


}
}
