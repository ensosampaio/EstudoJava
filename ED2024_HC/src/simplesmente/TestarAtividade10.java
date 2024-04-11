package simplesmente;
import dados.Item;



public class TestarAtividade10 {
public static void main(String[] args) {
	ListaSimples lista1 = new ListaSimples();
	ListaSimples lista2 = new ListaSimples();
	
	lista1.inserirUltimo(new Item(10));
	lista1.inserirUltimo(new Item(7));
	lista1.inserirUltimo(new Item(2));
	lista2.inserirUltimo(new Item(10));
	lista2.inserirUltimo(new Item(7));
	lista2.inserirUltimo(new Item(2));

	if (lista1.igualdadeL1L2(lista1,lista2)) {
		System.out.println("as listas sao identicas");
	}
	else {
		System.out.println("as listas sao diferentes");
	}
	


}
}
