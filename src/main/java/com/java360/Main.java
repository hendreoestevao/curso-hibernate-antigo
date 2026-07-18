package com.java360;


import com.java360.model.Endereco;
import com.java360.model.EstadoCivil;
import com.java360.model.Usuario;
import com.java360.model.Veiculo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setNome("Usuario Teste 4");
        usuario.setDataNascimento(new Date());
        usuario.setEstadoCivil(EstadoCivil.CASADO);

        Veiculo veiculo = new Veiculo("Fusca", 1966);
        Veiculo veiculo2 = new Veiculo("Brasilia", 1980);
      //  veiculo.setUsuario(usuario);
       // veiculo2.setUsuario(usuario);

        usuario.getVeiculos().add(veiculo);
        usuario.getVeiculos().add(veiculo2);
        veiculo.setUsuario(usuario);
        veiculo2.setUsuario(usuario);

//        Endereco endereco = new Endereco();
//        endereco.setLogradouro("Rua teste");
//        endereco.setNumero(123);
//        endereco.setCidade("Cidade Teste");
//
//
//        Endereco enderecoComercial = new Endereco();
//        enderecoComercial.setLogradouro("Rua teste C");
//        enderecoComercial.setNumero(12345);
//        enderecoComercial.setCidade("Cidade Teste C");
//
//        usuario.getEnderecos().add(endereco);
//        usuario.getEnderecos().add(enderecoComercial);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(usuario);
      // session.save(veiculo);
//      session.save(veiculo2);

        session.getTransaction().commit();

//        Usuario usuarioBanco = session.get(Usuario.class, 3);
//
//        System.out.println(usuarioBanco.getNome());
//
//        List<Endereco> enderecosBanco = usuarioBanco.getEnderecos();
//
//        enderecosBanco.forEach(e -> System.out.println(e.getLogradouro()));

        session.close();
    }
}