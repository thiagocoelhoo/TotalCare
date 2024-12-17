package br.edu.ufersa.pw.totalCare.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.totalCare.domain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
