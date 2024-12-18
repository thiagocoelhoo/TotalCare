package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.Consulta;
import br.edu.ufersa.pw.totalCare.domain.entities.Medico;
import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EConsultaEstado;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EConsultaUrgencia;

import java.time.LocalDateTime;

public class ConsultaDTO {
    private Long id;
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime data;
    private EConsultaUrgencia urgencia;
    private EConsultaEstado estado;

    public ConsultaDTO() {}

    public ConsultaDTO(Consulta consulta) {
        setId(consulta.getId());
        setMedico(consulta.getMedico());
        setPaciente(consulta.getPaciente());
        setData(consulta.getData());
        setUrgencia(consulta.getUrgencia());
        setEstado(consulta.getEstado());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
