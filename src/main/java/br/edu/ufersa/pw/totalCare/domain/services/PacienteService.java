package br.edu.ufersa.pw.totalCare.domain.services;

import br.edu.ufersa.pw.totalCare.api.dtos.PacienteDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;
import br.edu.ufersa.pw.totalCare.domain.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository repository;
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<PacienteDTO> buscarTodos(){
        List<PacienteDTO> result = repository.findAll().
                stream().map(paciente -> new PacienteDTO(paciente)).collect(Collectors.toList());
        return result;
    }

    public Paciente criarPaciente(PacienteDTO pacienteDTO){
       Paciente paciente = new Paciente();
       paciente.setNome(pacienteDTO.getNome());
       paciente.setSobrenome(pacienteDTO.getSobrenome());
       paciente.setCpf(pacienteDTO.getCpf());
       paciente.setRg(pacienteDTO.getRg());
       paciente.setCep(pacienteDTO.getCep());
       paciente.setEndereco(pacienteDTO.getEndereco());
       paciente.setBairro(pacienteDTO.getBairro());
       paciente.setTipoSanguineo(pacienteDTO.getTipoSanguineo());
       paciente.setTelefone(pacienteDTO.getTelefone());
       paciente.setAlergias(pacienteDTO.getAlergias());

       return repository.save(paciente);
    }

    public PacienteDTO buscarPorId(Long id){
        Paciente result = repository.findById(id).orElse(null);
        if (result == null){
            return null;
        }
        return new PacienteDTO(result);
    }

    public PacienteDTO atualizarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = repository.findById(pacienteDTO.getId()).orElse(null);

        if (paciente != null) {
            paciente.setNome(pacienteDTO.getNome());
            paciente.setSobrenome(pacienteDTO.getSobrenome());

            paciente.setCpf(pacienteDTO.getCpf());
            paciente.setRg(pacienteDTO.getRg());

            paciente.setCep(pacienteDTO.getCep());
            paciente.setEndereco(pacienteDTO.getEndereco());
            paciente.setBairro(pacienteDTO.getBairro());

            paciente.setTipoSanguineo(pacienteDTO.getTipoSanguineo());
            paciente.setTelefone(pacienteDTO.getTelefone());
            paciente.setAlergias(pacienteDTO.getAlergias());


            repository.save(paciente);
        }
        return new PacienteDTO(paciente);
    }

    public PacienteDTO deletarPaciente(Long id){
        Paciente paciente = repository.findById(id).orElse(null);
        if (paciente != null) {
            repository.delete(paciente);
        }
        return new PacienteDTO(paciente);
    }
}
