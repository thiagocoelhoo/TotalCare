package br.edu.ufersa.pw.totalCare.domain.repositories;

import br.edu.ufersa.pw.totalCare.domain.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
