package br.edu.ufersa.pw.totalCare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.pw.totalCare.dtos.UsuarioDTO;
import br.edu.ufersa.pw.totalCare.models.Usuario;
import br.edu.ufersa.pw.totalCare.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> criarUsuario (@RequestBody UsuarioDTO usuarioDto){

    try{
        Usuario usuarioCriado = usuarioService.criarUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
}

}
