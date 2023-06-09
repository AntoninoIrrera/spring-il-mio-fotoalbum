package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.auth.pojo.User;
import com.example.demo.interfaccia.FotoRepo;
import com.example.demo.pojo.Foto;

@Service
public class FotoService {

	
	@Autowired
	private FotoRepo fotoRepo;
	
	
	public List<Foto> findAll() {
		
		return fotoRepo.findAll();
	}
	public Foto save(Foto foto) {
		
		return fotoRepo.save(foto);
	}
	public Optional<Foto> findById(int id) {
		
		return fotoRepo.findById(id);
	}
	
	public List<Foto> findByTitolo(String nome) {
		
		return fotoRepo.findByTitoloContaining(nome);
	}
	
	public void deletePizza(Foto foto){
		
		fotoRepo.delete(foto);
		
	}
	
	public List<Foto> findByVisibileEquals(Boolean visibile) {
		
		return fotoRepo.findByVisibileEquals(visibile);
	}
	
	public List<Foto> findByTitoloAndVisibileEquals(String nome,boolean visibile) {
		
		return fotoRepo.findByTitoloContainingAndVisibileEquals(nome,visibile);
	}
	
	public List<Foto> findByUser(User user){
		return fotoRepo.findByUser(user);
	}
	
	public List<Foto> findByTitoloAndUser(String nome,User user) {
		
		return fotoRepo.findByTitoloContainingAndUser(nome,user);
	}
	
	
}
