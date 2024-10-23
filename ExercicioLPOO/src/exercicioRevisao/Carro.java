package exercicioRevisao;

public class Carro {
	private int codigo;
	private String modelo;
	private boolean locado;
	private static int numLocados = 0;
	
	public Carro(int codigo, String modelo, boolean locado) {
	
		this.codigo = codigo;
		this.modelo = modelo;
		this.locado = locado;
	}
	
	public Carro() {
	
		this.codigo = 0;
		this.modelo = "";
		this.locado = false;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isLocado() {
		return locado;
	}
	public void setLocado(boolean locado) {
		this.locado = locado;
	}
	public static int getNumLocados() {
		return numLocados;
	}
	public static void setNumLocados(int numLocados) {
		Carro.numLocados = numLocados;
	}
	
	public boolean locar() {
		if(isLocado()) {
			return false;
		}
		this.locado = true;
		Carro.numLocados++;
		return true;
		
	}
	
	public boolean devolver() {
		if (isLocado() == false) {
			return false;
		}
		this.locado = false;
		Carro.numLocados--;
		return true;
		
	}

	@Override
	public String toString() {
		return "Carro [codigo=" + codigo + ", modelo=" + modelo + ", locado=" + locado + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
