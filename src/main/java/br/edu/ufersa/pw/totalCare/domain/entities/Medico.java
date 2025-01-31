package br.edu.ufersa.pw.totalCare.domain.entities;

import br.edu.ufersa.pw.totalCare.api.dtos.MedicoCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.MedicoDTO;
import jakarta.persistence.*;

@Entity
@Table(name="medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    private String nome;
    private String especialidade;

    // Construtores
    public Medico() {}

    public Medico(Long id) {
        this.id = id;
    }

    public Medico(MedicoDTO medicoDTO) {
        this.id = medicoDTO.getId();
        this.crm = medicoDTO.getCrm();
        this.especialidade = medicoDTO.getEspecialidade();
        this.nome = medicoDTO.getNome();
    }

    public Medico(MedicoCreateDTO medico) {
        this.crm = medico.getCrm();
        this.nome = medico.getNome();
        this.especialidade = medico.getEspecialidade();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
