package com.example.demo.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.dto.CommentoResponseDto;
import com.example.demo.pojo.Commento;
import com.example.demo.pojo.Foto;
import com.example.demo.service.CommentoService;
import com.example.demo.service.FotoService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ApiCommentoController {

	
	@Autowired
	CommentoService commentoService;
	
	@Autowired
	FotoService fotoService;
	
	@PostMapping("/{id}/commento")
	public ResponseEntity<CommentoResponseDto> store(
			@RequestBody Commento commento, @Valid BindingResult bindingResult,@PathVariable("id") int id) {
		
		if (bindingResult.hasErrors()) {
			
			return new ResponseEntity<>(
					new CommentoResponseDto(bindingResult), 
					HttpStatus.BAD_REQUEST
				);
		}
		
		Foto foto = fotoService.findById(id).get();
		
		commento.setFoto(foto);
		
		commento = commentoService.save(commento);
		
		return new ResponseEntity<>(
				new CommentoResponseDto(commento), 
				HttpStatus.OK);	
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<CommentoResponseDto> handleConstraintViolationException(ConstraintViolationException ex) {
	    
	    List<String> errors = ex.getConstraintViolations()
	            .stream()
	            .map(ConstraintViolation::getMessage)
	            .collect(Collectors.toList());

	   
	    return new ResponseEntity<>(
	            new CommentoResponseDto(errors),
	            HttpStatus.BAD_REQUEST
	    );
	}
	
	
}
