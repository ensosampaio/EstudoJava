package exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class UsaPagamento {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

		cadastrarPagamento(pagamentos);
		realizarPagamento(pagamentos);
		estornarPagamento(pagamentos);
	}

	public static void cadastrarPagamento(ArrayList<Pagamento> pagamentos) {
		PagamentoCartaoCredito a = new PagamentoCartaoCredito(1200);
		PagamentoCartaoCredito b = new PagamentoCartaoCredito(3000);

		PagamentoBoleto c = new PagamentoBoleto(1);
		PagamentoBoleto d = new PagamentoBoleto(2);

		pagamentos.add(a);
		pagamentos.add(b);
		pagamentos.add(c);
		pagamentos.add(d);

		for (Pagamento pagamento : pagamentos) {
			if (pagamento instanceof PagamentoCartaoCredito) {
				System.out.println(((PagamentoCartaoCredito) pagamento).limite());
			} else if (pagamento instanceof PagamentoBoleto) {
				System.out.println(((PagamentoBoleto) pagamento).codigoPagamento());
			}
		}

	}

	public static void realizarPagamento(ArrayList<Pagamento> pagamentos) {

		System.out.println("Digite quanto será o pagamento: ");
		int valor = Integer.parseInt(teclado.nextLine());
		for (Pagamento pagamento : pagamentos) {
			if (pagamento instanceof PagamentoCartaoCredito) {
				if (pagamento.autorizarPagamento(valor)) {
					System.out.println("PAGAMENTO REALIZADO COM SUCESSO");
					System.out.println(((PagamentoCartaoCredito) pagamento).limite());
				} else {
					System.out.println("PAGAMENTO NAO REALIZADO. LIMITE DE CREDITO INSUFICIENTE");
					System.out.println(((PagamentoCartaoCredito) pagamento).limite());
				}
			} else if (pagamento instanceof PagamentoBoleto) {
				if (pagamento.autorizarPagamento(valor)) {
					System.out.println("PAGAMENTO REALIZADO COM SUCESSO");
					System.out.println(((PagamentoBoleto) pagamento).codigoPagamento());
				}
			}
		}

	}

	public static void estornarPagamento(ArrayList<Pagamento> pagamentos) {
		for (Pagamento pagamento : pagamentos) {
			if (pagamento instanceof PagamentoCartaoCredito) {
				pagamento.estornarPagamento(100);
				System.out.println("PAGAMENTO ESTORNADO!");
				System.out.println(((PagamentoCartaoCredito) pagamento).limite());
			}
		}
	}

}
