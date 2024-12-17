package br.edu.ufersa.pw.totalCare.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ufersa.pw.totalCare.dtos.UsuarioDTO;
import br.edu.ufersa.pw.totalCare.models.Usuario;
import br.edu.ufersa.pw.totalCare.models.Perfil;
import br.edu.ufersa.pw.totalCare.repositories.PerfilRepository;
import br.edu.ufersa.pw.totalCare.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    public Usuario criarUsuario(UsuarioDTO usuarioDto){
        


        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setDataCadastro(LocalDateTime.now());
        usuario.setPerfil(null);

        //TODO: FAZER A BUSCA DO PERFIL DEPOIS DE CRIAR A CRIAÇÃO DO PERFIL
        
        // Perfil perfil = perfilRepository.findById(usuarioDto.getPerfil().getId())
        // .orElse(new Perfil("USUARIO", null, null, null, null, null, null, null, null));

        // usuario.setPerfil(perfil);

        return usuarioRepository.save(usuario);
    }
}
