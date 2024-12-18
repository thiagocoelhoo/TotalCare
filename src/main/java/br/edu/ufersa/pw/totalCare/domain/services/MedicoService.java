package br.edu.ufersa.pw.totalCare.domain.services;

import br.edu.ufersa.pw.totalCare.api.dtos.MedicoCreateDTO;
import br.edu.ufersa.pw.totalCare.api.dtos.MedicoDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Medico;
import br.edu.ufersa.pw.totalCare.domain.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoDTO> buscarTodos() {
        return medicoRepository.findAll()
                .stream().map(medico -> new MedicoDTO(medico))
                .collect(Collectors.toList());
    }

    public MedicoDTO buscarPorId(Long id) {
        return null;
    }

    public MedicoDTO criarMedico(MedicoCreateDTO medicoDTO) {
        Medico medico = medicoRepository.save(new Medico(medicoDTO));
        return new MedicoDTO(medico);
    }

    public MedicoDTO deletarMedico(Long id) {
        return null;
    }

    public MedicoDTO atualizarMedico(MedicoCreateDTO medico) {
        return null;
    }
}
