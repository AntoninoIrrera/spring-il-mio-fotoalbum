package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaccia.CommentoRepo;
import com.example.demo.pojo.Commento;

@Service
public class CommentoService {

	
	@Autowired
	CommentoRepo commentoRepo;
	
	
public List<Commento> findAll() {
		
		return commentoRepo.findAll();
	}
	public Commento save(Commento commento) {
		
		return commentoRepo.save(commento);
	}
	public Optional<Commento> findById(int id) {
		
		return commentoRepo.findById(id);
	}
	
	
	
	public void delete(Commento commento){
		
		commentoRepo.delete(commento);
		
	}
	
}
