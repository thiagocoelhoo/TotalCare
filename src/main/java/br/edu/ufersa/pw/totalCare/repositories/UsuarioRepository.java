package br.edu.ufersa.pw.totalCare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.pw.totalCare.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
