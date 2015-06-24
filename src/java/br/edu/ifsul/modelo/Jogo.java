package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Jorge Luis Boeira Bavaresco jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_jogo", sequenceName = "seq_jogo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_jogo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O estadio não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O estadio deve ser informado")
    @Column(name = "estadio", length = 50, nullable = false)
    private String estadio;
    @NotNull(message = "A data e hora devem ser informadas")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataHora", nullable = false)
    private Calendar dataHora;
    @Length(max = 50, message = "O árbitro não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O árbitro deve ser informado")
    @Column(name = "arbitro", length = 50, nullable = false)
    private String arbitro;
    @Length(max = 50, message = "O primeiro auxiliar não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O primeiro auxiliar deve ser informado")
    @Column(name = "auxiliar_um", length = 50, nullable = false)
    private String auxiliarUm;
    @Length(max = 50, message = "O segundo auxiliar não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O segundo auxiliar deve ser informado")
    @Column(name = "auxiliar_dois", length = 50, nullable = false)
    private String auxiliarDois;
    @NotNull(message = "O campeonato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "campeonato", referencedColumnName = "id", nullable = false)     
    private Campeonato campeonato;
    @ManyToMany
    @JoinTable(name = "confrontos",
            joinColumns = 
            @JoinColumn(name = "jogo",referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "time", referencedColumnName = "id"))
    private List<Time> jogam = new ArrayList<>();
    public Jogo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getAuxiliarUm() {
        return auxiliarUm;
    }

    public void setAuxiliarUm(String auxiliarUm) {
        this.auxiliarUm = auxiliarUm;
    }

    public String getAuxiliarDois() {
        return auxiliarDois;
    }

    public void setAuxiliarDois(String auxiliarDois) {
        this.auxiliarDois = auxiliarDois;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public List<Time> getJogam() {
        return jogam;
    }

    public void setJogam(List<Time> jogam) {
        this.jogam = jogam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogo other = (Jogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jogo{" + "estadio=" + estadio + ", dataHora=" + dataHora + '}';
    }
}
