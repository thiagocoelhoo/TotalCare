package br.edu.ufersa.pw.totalCare.api.dtos;

import java.time.LocalDateTime;

import br.edu.ufersa.pw.totalCare.domain.entities.Perfil;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EPerfil;

public class UsuarioDTO {

    private Long id;
    private String email;
    private LocalDateTime dataCadastro;
    private Perfil perfil;
    private EPerfil tipoUsuario;
    private Boolean ativo;

    // Construtores
    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String email, LocalDateTime dataCadastro, Perfil perfil) {
        this.id = id;
        this.email = email;
        this.dataCadastro = dataCadastro;
        // this.perfil = perfil;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}