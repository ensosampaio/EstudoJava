package classe;

public class Produto {

	String nome;
	double preco;
	double disconto;
	
	double precoCompleto() {
		return preco * (1-disconto);		
	}
}
