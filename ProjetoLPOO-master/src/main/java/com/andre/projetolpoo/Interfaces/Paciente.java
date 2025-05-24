package com.andre.projetolpoo.Interfaces;

public interface Paciente extends Pessoa {
    public String getNome();
    public void setNome(String nome);
    public String getCpf();
    public void setCpf(String cpf);
    public String getTelefone();
    public void setTelefone(String telefone);
    public String toString();
}
