package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.Medico;

public class MedicoCreateDTO {
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
}
