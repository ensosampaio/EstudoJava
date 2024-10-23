package exercicioDiagnostico;

public class VetPaciente {

	private Paciente[] vet;
	private int nElem;

	public VetPaciente(int tamanho) {
		this.vet = new Paciente[tamanho];
		this.nElem = 0;
	}

	public int getNElem() {
		return nElem;
	}

	public Paciente getPaciente(int posicao) {

		if (posicao >= 0 && posicao < nElem) {
			return vet[posicao];
		} else {
			return null;
		}
	}

	public int pesquisa(String CPF) {

		for (int i = 0; i < nElem; i++) {
			if (vet[i].getCPF().equals(CPF)) {
				return i;
			}
		}

		return -1;
	}

	public int inserirPaciente(Paciente paciente) {
		if (nElem >= vet.length) {
			return -1;
		}
		if (pesquisa(paciente.getCPF()) != -1) {
			return -2;
		}
		vet[nElem] = paciente;
		nElem++;
		return 0;

	}

	public boolean removerPaciente(Paciente paciente) {
		int posicao = pesquisa(paciente.getCPF());
		if (posicao != -1) {

			for (int i = posicao; i < nElem - 1; i++) {
				vet[i] = vet[i + 1];
			}
			vet[nElem - 1] = null;
			nElem--;
			return true;
		}
		return false;
	}

	public String toString() {
		String resposta = " ";
		for (int i = 0; i < this.nElem; i++) {
			resposta += (i + 1) + " . " + this.vet[i].toString();
		}
		return resposta;
	}












}
