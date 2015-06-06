/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author bringha
 */
@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa implements Serializable{
    @Length(max = 50, message = "O apelido não deve ultrapassar {max} caracteres")
    @NotEmpty(message = "O apelido não pode ser nulo")
    @Column(name = "apelido", length = 50, nullable = false)
    private String apelido;
    @Length(max = 50, message = "A senha não deve ultrapassar {max} caracteres")
    @NotEmpty(message = "A senha não pode ser nula")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;
    @NotNull(message = "Deve ser informado se é administrador")
    @Column(name = "administrador", nullable = false)
    private Boolean administrador;

    public Usuario() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
    
}
