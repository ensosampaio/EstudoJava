package com.andre.projetolpoo.Models;

public class Medico extends Pessoa implements com.andre.projetolpoo.Interfaces.Medico {
    private String crm;
    private String especialidade;

    public Medico(String nome, String cpf, String telefone, String crm, String especialidade) {
        super(nome, cpf, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return getNome() + ";" + getCpf() + ";" + getTelefone() + ";" + getCrm() + ";" + getEspecialidade();
    }
}
