package com.andre.projetolpoo.Interfaces;

public interface Medico extends Pessoa {
    public String getNome();
    public void setNome(String nome);
    public String getTelefone();
    public void setTelefone(String telefone);
    public String getEspecialidade();
    public void setEspecialidade(String especialidade);
    public String toString();
}
