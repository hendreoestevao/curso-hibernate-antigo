package com.java360;


import com.java360.model.Endereco;
import com.java360.model.EstadoCivil;
import com.java360.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        //usuario.setId(3);
        usuario.setNome("Usuario Teste 4");
        usuario.setDataNascimento(new Date());
        usuario.setIdade(30);
        usuario.setEstadoCivil(EstadoCivil.CASADO);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua teste");
        endereco.setNumero(123);
        endereco.setCidade("Cidade Teste");

        usuario.setEndereco(endereco);

        Endereco enderecoComercial = new Endereco();
        enderecoComercial.setLogradouro("Rua teste C");
        enderecoComercial.setNumero(12345);
        enderecoComercial.setCidade("Cidade Teste C");
        usuario.setEnderecoComercial(enderecoComercial);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(usuario);

        session.getTransaction().commit();

       Usuario usuarioBanco = session.get(Usuario.class, usuario.getId());
        System.out.println(usuarioBanco.getNome());



        session.close();
    }
}