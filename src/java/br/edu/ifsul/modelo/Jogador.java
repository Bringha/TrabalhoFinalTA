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
    @Column(name = "nro_gols")
    private Integer nroGols;
    @Column(name = "amarelos")
    private Integer cartoesAmarelos;
    @Column(name = "vermelhos")
    private Integer cartoesVermelhos;
    
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

    public Integer getNroGols() {
        return nroGols;
    }

    public void setNroGols(Integer nroGols) {
        this.nroGols = nroGols;
    }

    public Integer getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public void setCartoesAmarelos(Integer cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }

    public Integer getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public void setCartoesVermelhos(Integer cartoesVermelhos) {
        this.cartoesVermelhos = cartoesVermelhos;
    }
}
