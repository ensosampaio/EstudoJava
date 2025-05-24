package com.andre.projetolpoo.Models;

public class Consulta implements com.andre.projetolpoo.Interfaces.Consulta {
    String paciente;
    String medico;
    String clinica;
    String data;
    String hora;

    public Consulta(String paciente, String medico, String clinica, String data, String hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.clinica = clinica;
        this.data = data;
        this.hora = hora;
    }

    @Override
    public String getPaciente() {
        return this.paciente;
    }

    @Override
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @Override
    public String getMedico() {
        return this.medico;
    }

    @Override
    public void setMedico(String medico) {
        this.medico = medico;
    }

    @Override
    public String getClinica() {
        return this.clinica;
    }

    @Override
    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getHora() {
        return this.hora;
    }

    @Override
    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return paciente + ";" + medico + ";" + clinica + ";" + data + ";" + hora;
    }
}
