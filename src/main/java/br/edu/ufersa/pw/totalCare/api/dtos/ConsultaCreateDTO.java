package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.enums.EConsultaEstado;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EConsultaUrgencia;

import java.time.LocalDateTime;

public class ConsultaCreateDTO {
    private Long id;
    private Long idMedico;
    private Long idPaciente;
    private LocalDateTime data;
    private EConsultaUrgencia urgencia;
    private EConsultaEstado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public EConsultaUrgencia getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(EConsultaUrgencia urgencia) {
        this.urgencia = urgencia;
    }

    public EConsultaEstado getEstado() {
        return estado;
    }

    public void setEstado(EConsultaEstado estado) {
        this.estado = estado;
    }
}
