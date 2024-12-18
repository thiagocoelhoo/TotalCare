package br.edu.ufersa.pw.totalCare.domain.services;

import br.edu.ufersa.pw.totalCare.api.dtos.ConsultaCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.ConsultaDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Consulta;
import br.edu.ufersa.pw.totalCare.domain.entities.Medico;
import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;
import br.edu.ufersa.pw.totalCare.domain.repositories.ConsultaRepository;
import br.edu.ufersa.pw.totalCare.domain.repositories.MedicoRepository;
import br.edu.ufersa.pw.totalCare.domain.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<ConsultaDTO> buscarTodos() {
        return consultaRepository.findAll()
                .stream().map(consulta -> new ConsultaDTO(consulta))
                .collect(Collectors.toList());
    }

    public ConsultaDTO criarConsulta(ConsultaCreateDTO consultaDTO) {
        Consulta consulta = new Consulta();

        consulta.setMedico(new Medico(consultaDTO.getIdMedico()));
        consulta.setPaciente(new Paciente(consultaDTO.getIdPaciente()));
        consulta.setData(consultaDTO.getData());
        consulta.setUrgencia(consultaDTO.getUrgencia());
        consulta.setEstado(consultaDTO.getEstado());
        consultaRepository.save(consulta);

        Medico medico = medicoRepository.findById(consultaDTO.getIdMedico()).get();
        Paciente paciente = pacienteRepository.findById(consultaDTO.getIdMedico()).get();

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return new ConsultaDTO(consulta);
    }

    public ConsultaDTO buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElse(null);

        if (consulta == null) {
            return null;
        }

        return new ConsultaDTO(consulta);
    }

    public ConsultaDTO atualizarConsulta(ConsultaCreateDTO consultaDTO) {
        Consulta consulta = consultaRepository.findById(consultaDTO.getId()).orElse(null);

        if (consulta == null) {
            return null;
        }

        consulta.setMedico(new Medico(consultaDTO.getIdMedico()));
        consulta.setPaciente(new Paciente(consultaDTO.getIdPaciente()));
        consulta.setEstado(consultaDTO.getEstado());
        consulta.setUrgencia(consultaDTO.getUrgencia());
        consulta.setData(consultaDTO.getData());
        consultaRepository.save(consulta);

        return new ConsultaDTO(consulta);
    }

    public ConsultaDTO deletarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElse(null);

        if (consulta == null) {
            return null;
        }

        consultaRepository.delete(consulta);
        return new ConsultaDTO(consulta);
    }

}
