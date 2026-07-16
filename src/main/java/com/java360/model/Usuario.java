package com.java360.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity(name = "usu_usuario")
@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Transient
    private Integer idade;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "usu_endereco", joinColumns = @JoinColumn(name = "id_usuario"))
    private List<Endereco> enderecos = new ArrayList<>();


//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "logradouro", column = @Column(name = "rua"))
//    })
//    private Endereco endereco;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "logradouro", column = @Column(name = "log")),
//            @AttributeOverride(name = "cidade", column = @Column(name = "cid")),
//            @AttributeOverride(name = "numero", column = @Column(name = "num"))
//    })
//    private Endereco enderecoComercial;


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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
