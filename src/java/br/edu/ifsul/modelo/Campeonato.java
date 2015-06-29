/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author bringha
 */
@Entity
@Table(name = "campeonato")
public class Campeonato implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_campeonato", sequenceName = "seq_campeonato_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_campeonato", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome", length = 50, nullable = false, unique = true)
    private String nome;
    @NotNull(message = "O usuário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)     
    private Usuario usuario;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campeao")
    private Times campeao;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vice")
    private Times vice;
    @NotNull(message = "O prêmio deve ser informado")
    @Column(name = "premio", columnDefinition = "decimal(12,2)", nullable = false)
    private Double premio;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artilheiro")
    private Jogador artilheiro;

    public Campeonato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Times getCampeao() {
        return campeao;
    }

    public void setCampeao(Times campeao) {
        this.campeao = campeao;
    }

    public Times getVice() {
        return vice;
    }

    public void setVice(Times vice) {
        this.vice = vice;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public Jogador getArtilheiro() {
        return artilheiro;
    }

    public void setArtilheiro(Jogador artilheiro) {
        this.artilheiro = artilheiro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
