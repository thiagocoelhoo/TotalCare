package br.edu.ufersa.pw.totalCare.domain.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Usuario;
import br.edu.ufersa.pw.totalCare.domain.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

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

    public ResponseEntity<Usuario> buscarPorId(Long id){
        return ResponseEntity.ok(usuarioRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Usuario> atualizarUsuario(UsuarioDTO usuarioDto){
        Usuario usuario = usuarioRepository.findById(usuarioDto.getId()).orElse(null);
        if(usuario != null){
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setSenha(usuarioDto.getSenha());
            usuarioRepository.save(usuario);
        }
        return ResponseEntity.ok(usuario);
    }

    public ResponseEntity<Usuario> deletarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario != null){
            usuarioRepository.delete(usuario);
        }
        return ResponseEntity.ok(usuario);
        
    }
}
