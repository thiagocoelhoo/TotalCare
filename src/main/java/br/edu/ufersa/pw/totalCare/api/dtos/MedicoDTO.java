package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.Medico;

public class MedicoDTO {
    private Long id;
    private String crm;

    // Construtores
    public MedicoDTO() {}

    public MedicoDTO(Medico medico) {
        this.id = medico.getId();
        this.crm = medico.getCrm();
    }

    // Getters and setters

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
