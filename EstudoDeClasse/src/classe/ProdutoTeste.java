package classe;


public class ProdutoTeste {

	public static void main(String[] args) {
		
		Produto p1 = new Produto(); // instanciar objeto da classe
		
		p1.nome = "Notebook";
		p1.preco = 4356.89;
		p1.disconto = 0.25;
		
		var p2 = new Produto();
		p2.nome = "Caneta Preta";
		p2.preco = 12.56;
		p2.disconto = 0.29;
		
		double precoFinal1 = p1.precoCompleto();
		double precoFinal2 = p2.precoCompleto();
		
		
		System.out.println(precoFinal1);
		System.out.println(precoFinal2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
