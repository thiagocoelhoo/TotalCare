package br.edu.ufersa.pw.totalCare.api.dtos;

import br.edu.ufersa.pw.totalCare.domain.entities.Perfil;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EPerfil;

import java.time.LocalDateTime;

public class UsuarioCreateDTO {

    private Long id;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private Perfil perfil;
    private EPerfil tipoUsuario;

    // Construtores
    public UsuarioCreateDTO() {
    }

    public UsuarioCreateDTO(Long id, String email, String senha, LocalDateTime dataCadastro, Perfil perfil, EPerfil tipoUsuario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        // this.perfil = perfil;
        this.perfil = perfil;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public EPerfil getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(EPerfil tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}