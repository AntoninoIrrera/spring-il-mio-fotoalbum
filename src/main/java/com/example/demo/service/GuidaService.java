package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaccia.GuidaRepo;
import com.example.demo.pojo.Guida;

@Service
public class GuidaService {

	@Autowired
	GuidaRepo guidaRepo;
	
	
public List<Guida> findAll() {
		
		return guidaRepo.findAll();
	}
	public Guida save(Guida lead) {
		
		return guidaRepo.save(lead);
	}
	public Optional<Guida> findById(int id) {
		
		return guidaRepo.findById(id);
	}
	
	
	
	public void deletePizza(Guida lead){
		
		guidaRepo.delete(lead);
		
	}
}
