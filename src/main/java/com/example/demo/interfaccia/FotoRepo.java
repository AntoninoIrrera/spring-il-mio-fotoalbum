package com.example.demo.interfaccia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.auth.pojo.User;
import com.example.demo.pojo.Foto;

public interface FotoRepo extends JpaRepository<Foto, Integer>{

	List<Foto> findByTitoloContaining(String nome);

	List<Foto> findByVisibileEquals(Boolean visibile);

	List<Foto> findByTitoloContainingAndVisibileEquals(String nome, boolean visibile);

	List<Foto> findByUser(User user);

	List<Foto> findByTitoloContainingAndUser(String nome, User user);

}
