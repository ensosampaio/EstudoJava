package exercicioLista1;



/*
1) Uma empresa deve informatizar seu estoque. Para isso, faça:
a) Uma classe com os atributos de cada produto (código,
descrição, valor unitário, quantidade em estoque, quantidade
mínima no estoque), os métodos gets, sets e toString.
b) Um aplicativo que:
b.1) Armazene 10 produtos
b.2) Permita alterar valor unitário ou quantidade em estoque de
um produto (a chave de pesquisa será seu código).
b.3) Permita pesquisar todos os produtos cuja descrição começa
por uma determinada letra (informada pelo usuário)
b.4) Listar todos os produtos cuja quantidade em estoque é
menor que a quantidade mínima.
 */


public class EstoqueVet {

	private Estoque vet[];
	private int nElem;
	
	EstoqueVet (int tamanho) {
		this.vet = new Estoque [tamanho];
		this.nElem = 0;
	}
	
	
	
	public int getNElem() {
		return nElem;
	}

	public Estoque getProduto(int posicao) {
		if(posicao >= 0 && posicao <nElem) {
			return vet[posicao];
		}else {
			return null;
		}
	}

	public int pesquisarCodigo(int codigo) {
		for (int i = 0; i<nElem; i++) {
			if (vet[i].getCodigo() == codigo) {
				return i;
			}

		}
		return -1;
	}


	public int inserirPaciente(Estoque estoque) {
		if (nElem >= vet.length) {
			return -1;
		}
		if (pesquisarCodigo(estoque.getCodigo()) != -1) {
			return -2;
		}
		vet[nElem] = estoque;
		nElem++;
		return 0;

	}


	public Estoque[] verificarEstoque(Estoque estoque) {
		
		int contador = 0;
		
		for (int i = 0; i<nElem; i++) {
			if (vet[i] != null && vet[i].getQntEstoque() < vet[i].getQntMin()) {
				contador++;
			}
		}
		Estoque[] produtoAbaixoMinimo = new Estoque[contador];
		int index = 0;
		
		for (int i = 0; i<nElem; i++) {
			if (vet[i] != null & vet[i].getQntEstoque() < vet[i].getQntMin()) {
				produtoAbaixoMinimo[index] = vet[i];
				index ++;
			}
		}
		
		return produtoAbaixoMinimo;
	}



	public String toString() {
		String resposta = " ";
		for (int i = 0; i < this.nElem; i++) {
			resposta += (i + 1) + " . " + this.vet[i].toString();
		}
		return resposta;
	}








}
