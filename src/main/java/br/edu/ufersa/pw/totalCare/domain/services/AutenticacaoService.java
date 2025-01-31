package br.edu.ufersa.pw.totalCare.domain.services;

import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioCreateDTO;
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

        if (!senha.equals(usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        UsuarioCreateDTO usuarioDTO = new UsuarioCreateDTO(
            usuario.getId(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getDataCadastro(),
            usuario.getPerfil(),
            usuario.getTipoUsuario()
        );

        return tokenService.generateToken(usuarioDTO);
    }
}
