package br.edu.ufersa.pw.totalCare.domain.entities;

import br.edu.ufersa.pw.totalCare.api.dtos.MedicoCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.MedicoDTO;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;

    // Construtores
    public Medico() {}

    public Medico(Long id) {
        this.id = id;
    }

    public Medico(MedicoDTO medicoDTO) {
        this.id = medicoDTO.getId();
        this.crm = medicoDTO.getCrm();
    }

    public Medico(MedicoCreateDTO medico) {
        this.crm = medico.getCrm();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
