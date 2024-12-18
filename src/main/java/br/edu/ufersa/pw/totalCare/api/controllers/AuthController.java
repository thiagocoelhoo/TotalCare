package br.edu.ufersa.pw.totalCare.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ufersa.pw.totalCare.api.dtos.LoginDTO;
import br.edu.ufersa.pw.totalCare.domain.services.AutenticacaoService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String token = autenticacaoService.login(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(token);
    }
}