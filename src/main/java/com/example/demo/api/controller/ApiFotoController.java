package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Foto;
import com.example.demo.service.FotoService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ApiFotoController {

	@Autowired
	FotoService fotoService;
	
	@GetMapping("/foto")
	public ResponseEntity<List<Foto>> index() {
		
		List<Foto> foto = fotoService.findByVisibileEquals(true);
		
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}
	
	
	@GetMapping("/foto/{id}")
	public ResponseEntity<Foto> show(@PathVariable int id) {
		
		Foto foto = fotoService.findById(id).get();
		
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}
	
	@GetMapping("/foto/filtro")
	public ResponseEntity<List<Foto>> filtro(@RequestParam(required = false) String titolo){
		
		List<Foto> foto = fotoService.findByTitoloAndVisibileEquals(titolo,true);
		
	
		
		return new ResponseEntity<>(foto,HttpStatus.OK);
		
	}
	
	
	
	
}
