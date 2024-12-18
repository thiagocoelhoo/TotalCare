package br.edu.ufersa.pw.totalCare.domain.repositories;

import br.edu.ufersa.pw.totalCare.domain.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
