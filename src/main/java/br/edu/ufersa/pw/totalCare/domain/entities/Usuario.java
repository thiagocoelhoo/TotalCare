package br.edu.ufersa.pw.totalCare.domain.entities;


import br.edu.ufersa.pw.totalCare.api.dtos.UsuarioCreateDTO;
import br.edu.ufersa.pw.totalCare.domain.entities.enums.EPerfil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    private Boolean ativo;

    @Column(name = "tipo_usuario")
    private EPerfil tipoUsuario;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(UsuarioCreateDTO usuarioCreateDTO) {
        this.email = usuarioCreateDTO.getEmail();
        this.senha = usuarioCreateDTO.getSenha();
        this.dataCadastro = usuarioCreateDTO.getDataCadastro();
        this.perfil = usuarioCreateDTO.getPerfil();
        this.tipoUsuario = usuarioCreateDTO.getTipoUsuario();
    }

    public Usuario(String email, String senha, LocalDateTime dataCadastro, Perfil perfil) {
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
