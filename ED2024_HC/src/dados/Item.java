package dados;

public class Item {
	private int chave;
	// aqui podem ser declarados outros atributos conforme sua necessidade.
	
	//Construtor de objetos da classe Item
	public Item(int valor) {
		this.chave = valor;
	}
	//Modifica o valor do atributo chave
	public void setChave (int chave){
		this.chave = chave;
	}
	//Faz a leitura do valor do atributo chave
	public int getChave (){
		return this.chave;
	}

}
