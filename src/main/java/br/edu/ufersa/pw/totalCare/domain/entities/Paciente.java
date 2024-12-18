package br.edu.ufersa.pw.totalCare.domain.entities;

import br.edu.ufersa.pw.totalCare.api.dtos.PacienteDTO;
import jakarta.persistence.*;


@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Paciente(){

    }

    public Paciente(Long id) {
        this.id = id;
    }

    public Paciente(PacienteDTO pacienteDTO){
        setNome(pacienteDTO.getNome());
        setSobrenome(pacienteDTO.getSobrenome());
        setCpf(pacienteDTO.getCpf());
        setRg(pacienteDTO.getRg());
        setCep(pacienteDTO.getCep());

        setEndereco(pacienteDTO.getEndereco());

        setBairro(pacienteDTO.getBairro());
        setTipoSanguineo(pacienteDTO.getTipoSanguineo());
        setTelefone(pacienteDTO.getTelefone());
        setAlergias(pacienteDTO.getAlergias());
    }

    public Paciente(String nome, String sobrenome, String cpf, String rg,
                    String cep, String endereco, String bairro, String tipoSanguineo,
                    String telefone, String alergias) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.tipoSanguineo = tipoSanguineo;
        this.telefone = telefone;
        this.alergias = alergias;
    }

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
