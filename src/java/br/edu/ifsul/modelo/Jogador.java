/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bringha
 */
@Entity
@Table(name = "jogador")
public class Jogador extends Pessoa implements Serializable{
    @NotNull(message = "O nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @Column(name = "nro_partidas")
    private Integer nroPartidas;
    @Column(name = "gols")
    private Integer gols;
    @Column(name = "amarelos")
    private Integer amarelos;
    @Column(name = "vermelhos")
    private Integer vermelhos;
    @NotNull(message = "O time deve ser informado")
    @ManyToOne
    @JoinColumn(name = "time", referencedColumnName = "id", nullable = false)
    private Times time;
    
    public Jogador() {
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getNroPartidas() {
        return nroPartidas;
    }

    public void setNroPartidas(Integer nroPartidas) {
        this.nroPartidas = nroPartidas;
    }

    public Integer getGols() {
        return gols;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }

    public Integer getAmarelos() {
        return amarelos;
    }

    public void setAmarelos(Integer amarelos) {
        this.amarelos = amarelos;
    }

    public Integer getVermelhos() {
        return vermelhos;
    }

    public void setVermelhos(Integer vermelhos) {
        this.vermelhos = vermelhos;
    }

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }
}
