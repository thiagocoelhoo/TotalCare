package br.edu.ufersa.pw.totalCare.api.controllers;

import java.util.List;

import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.Usuario;
import br.edu.ufersa.pw.totalCare.domain.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @PostMapping("")
    public ResponseEntity<Usuario> criarUsuario (@RequestBody UsuarioCreateDTO usuarioDto){
        try{
            Usuario usuarioCriado = usuarioService.criarUsuario(usuarioDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioCreateDTO usuarioDto){
        usuarioDto.setId(id);

        try{
            ResponseEntity<Usuario> responseEntity = usuarioService.atualizarUsuario(usuarioDto);
            Usuario usuarioAtualizado = responseEntity.getBody();
            return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id){

        try{
            usuarioService.deletarUsuario(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar usuário");
        }
    }
    
}

