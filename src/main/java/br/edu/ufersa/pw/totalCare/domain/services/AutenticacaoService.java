package br.edu.ufersa.pw.totalCare.domain.services;

import br.edu.ufersa.pw.totalCare.domain.entities.Usuario;
import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.totalCare.domain.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Comparação direta de senha (sem criptografia)
        if (!senha.equals(usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        // Criação do UsuarioDTO para o TokenService
        UsuarioDTO usuarioDTO = new UsuarioDTO(
            usuario.getId(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getDataCadastro(),
            usuario.getPerfil()
        );

        // Geração do token JWT
        return tokenService.generateToken(usuarioDTO);
    }
}
