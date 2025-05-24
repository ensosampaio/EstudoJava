package dados;

public class Item {
	private int chave;

	public Item(int chave) {
		this.chave = chave;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
	/*
	 * A Pesquisa Binária é geralmente mais eficiente do que a 
	 * Pesquisa Sequencial para listas ordenadas devido à sua complexidade logarítmica, 
	 * enquanto a Pesquisa Sequencial é simples e útil para listas pequenas ou não ordenadas.
	 * 
	 * Pesquisa Sequencial
Descrição: A Pesquisa Sequencial (ou Pesquisa Linear) é um algoritmo que percorre todos os elementos de uma lista de forma sequencial até encontrar o elemento desejado ou chegar ao final da lista.

Melhor Caso
Condição: O elemento desejado está na primeira posição da lista. Complexidade: O(1)

No melhor caso, o algoritmo encontra o elemento desejado logo na primeira comparação.

Pior Caso
Condição: O elemento desejado não está na lista ou está na última posição. Complexidade: O(n)

No pior caso, o algoritmo precisa percorrer todos os elementos da lista para concluir que o elemento não está presente ou para encontrá-lo na última posição.

Caso Médio
Condição: O elemento desejado está em uma posição aleatória. Complexidade: O(n)

Em média, o algoritmo terá que percorrer metade dos elementos da lista, resultando em uma complexidade linear.

Pesquisa Binária
Descrição: A Pesquisa Binária é um algoritmo eficiente para encontrar um elemento em uma lista ordenada, dividindo repetidamente a lista ao meio até encontrar o elemento desejado ou reduzir a lista a um tamanho de zero.

Melhor Caso
Condição: O elemento desejado está exatamente no meio da lista na primeira comparação. Complexidade: O(1)

No melhor caso, o algoritmo encontra o elemento na primeira comparação.

Pior Caso
Condição: O elemento desejado não está na lista, ou está em uma das extremidades da lista ordenada. Complexidade: O(log n)

No pior caso, o algoritmo reduz a lista ao meio repetidamente até que a lista tenha tamanho zero ou encontre o elemento nas últimas comparações.

Caso Médio
Condição: O elemento desejado está em uma posição aleatória em uma lista ordenada. Complexidade: O(log n)

Em média, a Pesquisa Binária vai precisar de aproximadamente log₂(n) comparações para encontrar o elemento desejado ou determinar que ele não está presente.

	 */
}
