package com.andre.projetolpoo.Models;

public class Paciente extends Pessoa implements com.andre.projetolpoo.Interfaces.Paciente {
    private String convenio;
    private String tipoSanguineo;
    private String alergias;
    private String observacoes;

    public Paciente(String nome, String cpf, String telefone, String convenio, String tipoSanguineo, String alergias, String observacoes) {
        super(nome, cpf, telefone);
        this.convenio = convenio;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = alergias;
        this.observacoes = observacoes;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }



    @Override
    public String toString() {
        return getNome() + ";" + getCpf() + ";" + getTelefone() + ";" + getConvenio() + ";" + getTipoSanguineo() + ";" + getAlergias() + ";" + getObservacoes();
    }
}
