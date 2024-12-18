package br.edu.ufersa.pw.totalCare.domain.entities;

import br.edu.ufersa.pw.totalCare.api.dtos.ConsultaDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EConsultaEstado;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EConsultaUrgencia;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    private LocalDateTime data;
    private EConsultaUrgencia urgencia;
    private EConsultaEstado estado;

    // Construtores
    public Consulta() {}
    public Consulta(ConsultaDTO consultaDTO) {
        setMedico(consultaDTO.getMedico());
        setPaciente(consultaDTO.getPaciente());
        setData(consultaDTO.getData());
        setUrgencia(consultaDTO.getUrgencia());
        setEstado(consultaDTO.getEstado());
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public EConsultaUrgencia getUrgencia() {
        return urgencia;
    }

    public EConsultaEstado getEstado() {
        return estado;
    }

    // Setters

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setUrgencia(EConsultaUrgencia urgencia) {
        this.urgencia = urgencia;
    }

    public void setEstado(EConsultaEstado estado) {
        this.estado = estado;
    }
}
