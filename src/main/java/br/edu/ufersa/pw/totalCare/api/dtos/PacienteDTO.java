package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;

public class PacienteDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private String cep;
    private String endereco;
    private String bairro;
    private String tipoSanguineo;
    private String telefone;
    private String alergias;

    //Construtores
    public PacienteDTO() {

    }

    public PacienteDTO(Paciente paciente) {
        setId(paciente.getId());
        setNome(paciente.getNome());
        setSobrenome(paciente.getSobrenome());
        setCpf(paciente.getCpf());
        setRg(paciente.getRg());
        setCep(paciente.getCep());
        setEndereco(paciente.getEndereco());
        setBairro(paciente.getBairro());
        setTipoSanguineo(paciente.getTipoSanguineo());
        setTelefone(paciente.getTelefone());
        setAlergias(paciente.getAlergias());


    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
}
