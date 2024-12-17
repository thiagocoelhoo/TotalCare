package br.edu.ufersa.pw.totalCare.dtos;

import java.time.LocalDateTime;

import br.edu.ufersa.pw.totalCare.models.Perfil;

public class UsuarioDTO {

    private Long id;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private Perfil perfil;

    // Construtores
    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String email, String senha, LocalDateTime dataCadastro, Perfil perfil) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
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
}