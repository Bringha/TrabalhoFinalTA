package br.edu.ifsul.modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author bringha
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Pessoa")
public abstract class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_id_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 100, message = "O nome não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @NotNull(message = "Deve ser informado se é ativo")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @NotNull(message = "A cidade deve ser informada")
//    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL,
//            orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<AcessoUsuario> acessos = new ArrayList<>();
//    
    
//    public List<AcessoUsuario> getAcessos() {
//        return acessos;
//    }
//
//    public void setAcessos(List<AcessoUsuario> acessos) {
//        this.acessos = acessos;
//    }
//
//    public void adicionarAcesso(AcessoUsuario obj) {
//        obj.setPessoa(this);
//        this.getAcessos().add(obj);
//    }

    public Pessoa() {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
