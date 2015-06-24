/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author bringha
 */
@Entity
@Table(name = "time")
public class Time implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_time", sequenceName = "seq_time_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_time", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome", length = 50, nullable = false, unique = true)
    private String nome;
    @Column(name = "vitorias")
    private Integer vitorias;
    @Column(name = "empates")
    private Integer empates;
    @Column(name = "derrotas")
    private Integer derrotas;
    @Column(name = "golsPro")
    private Integer golPro;
    @Column(name = "golsContra")
    private Integer golsContra;
    @ManyToMany
    @JoinTable(name = "confrontos",
            joinColumns = 
            @JoinColumn(name = "time",referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "jogo", referencedColumnName = "id"))
    private List<Jogo> jogos = new ArrayList<>();

    public Time() {
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

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getGolPro() {
        return golPro;
    }

    public void setGolPro(Integer golPro) {
        this.golPro = golPro;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    public void adicionarJogos(Jogo obj){
        if (!this.getJogos().contains(obj)){
            this.getJogos().add(obj);
        }
    }
    
    public void removerJogos(Jogo obj){
        this.getJogos().remove(obj);
    }
}
