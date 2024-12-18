package br.edu.ufersa.pw.totalCare.domain.repositories;

import br.edu.ufersa.pw.totalCare.domain.entities.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //Paciente findByPaciente(Long id);
}
