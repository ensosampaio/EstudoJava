package dados;

import java.util.ArrayList;
import java.util.Arrays;

public class Locacao {

	private int codigoLocacao;
	private String dataLocacao;
	private String dataDevolucao;
	private int codigoCliente;
	private int codigoJogo;
	private int codigoDevolucao;

	public Locacao(int codigoLocacao, String dataLocacao, String dataDevolucao, int codigoCliente, int codigoJogo,
			int codigoDevolucao) {
		this.codigoLocacao = codigoLocacao;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.codigoCliente = codigoCliente;
		this.codigoJogo = codigoJogo;
		this.codigoDevolucao = codigoDevolucao;
	}

	public Locacao() {
		this.codigoLocacao = 0;
		this.dataLocacao = "";
		this.dataDevolucao = " ";
		this.codigoCliente = 0;
		this.codigoJogo = 0;
		this.codigoDevolucao = 0;
	}

	public int getCodigoLocacao() {
		return codigoLocacao;
	}

	public void setCodigoLocacao(int codigoLocacao) {
		this.codigoLocacao = codigoLocacao;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoJogo() {
		return codigoJogo;
	}

	public void setCodigoJogo(int codigoJogo) {
		this.codigoJogo = codigoJogo;
	}

	public int getCodigoDevolucao() {
		return codigoDevolucao;
	}

	public void setCodigoDevolucao(int codigoDevolucao) {
		this.codigoDevolucao = codigoDevolucao;
	}

	@Override
	public String toString() {
		return "Codigo locacao: " + codigoLocacao + ", " + "Data locacao: " + dataLocacao + ", " + "Data devolucao: "
				+ dataDevolucao + ", " + "Codigo cliente: " + codigoCliente + ", " + "Codigo jogo: " + codigoJogo + ", "
				+ "Codigo Devolucao: " + codigoDevolucao;
	}

	public static Locacao fromString(String str) {
		ArrayList<String> parte = new ArrayList<>(Arrays.asList(str.split(", ")));

		System.out.println("Debug: partes da string - " + parte);

		if (parte.size() < 5) {
			System.err.println("Formato de string inválido para Locacao: " + str);
			throw new IllegalArgumentException("Formato de string inválido para Locacao");
		}

		int codigoLocacao = Integer.parseInt(parte.get(0).replace("Codigo locacao: ", "").trim());
		String dataLocacao = parte.get(1).replace("Data locacao: ", "").trim();
		String dataDevolucao = parte.get(2).replace("Data devolucao: ", "").trim();
		int codigoCliente = Integer.parseInt(parte.get(3).replace("Codigo cliente: ", "").trim());
		int codigoJogo = Integer.parseInt(parte.get(4).replace("Codigo jogo: ", "").trim());
		int codigoDevolucao = Integer.parseInt(parte.get(5).replace("Codigo Devolucao: ", "").trim());
		return new Locacao(codigoLocacao, dataLocacao, dataDevolucao, codigoCliente, codigoJogo, codigoDevolucao);
	}
}