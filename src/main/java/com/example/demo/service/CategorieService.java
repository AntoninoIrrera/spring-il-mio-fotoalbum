package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaccia.CategorieRepo;
import com.example.demo.pojo.Categorie;

@Service
public class CategorieService {

	
	@Autowired
	private CategorieRepo categorieRepo;
	
	public List<Categorie> findAll() {
		
		return categorieRepo.findAll();
	}
	public Optional<Categorie> findById(int id) {
		
		return categorieRepo.findById(id);
	}
	public Categorie save(Categorie categorie) {
		
		return categorieRepo.save(categorie);
	}
	
	public void delete(Categorie categorie){
		
		categorieRepo.delete(categorie);
		
	}
	
}
