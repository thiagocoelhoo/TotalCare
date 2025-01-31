package br.edu.ufersa.pw.totalCare.domain.services;

import java.time.LocalDateTime;
import java.util.List;

import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioCreateDTO;
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

    public Usuario criarUsuario(UsuarioCreateDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO);
        usuario.setDataCadastro(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }

    public ResponseEntity<Usuario> buscarPorId(Long id){
        return ResponseEntity.ok(usuarioRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Usuario> atualizarUsuario(UsuarioCreateDTO usuarioDto){
        Usuario usuario = usuarioRepository.findById(usuarioDto.getId()).orElse(null);
        if(usuario != null){
            if (usuarioDto.getEmail() != null){
                usuario.setEmail(usuarioDto.getEmail());
            }

            if (usuarioDto.getSenha() != null){
                usuario.setSenha(usuarioDto.getSenha());
            }

            if (usuarioDto.getTipoUsuario() != null){
                usuario.setTipoUsuario(usuarioDto.getTipoUsuario());
            }

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
