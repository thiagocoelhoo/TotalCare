package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.Medico;

public class MedicoCreateDTO {
    private Long id;
    private String crm;
    private String nome;
    private String especialidade;

    // Construtores
    public MedicoCreateDTO() {}

    public MedicoCreateDTO(Medico medico) {
        this.crm = medico.getCrm();
    }

    // Getters and setters
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
