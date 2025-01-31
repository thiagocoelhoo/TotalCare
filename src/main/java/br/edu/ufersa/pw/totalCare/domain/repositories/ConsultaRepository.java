package br.edu.ufersa.pw.totalCare.domain.repositories;

import br.edu.ufersa.pw.totalCare.domain.entities.Consulta;
import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    public List<Consulta> findByPaciente(Paciente paciente);
}
