package com.example.demo.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.dto.CommentoResponseDto;
import com.example.demo.pojo.Commento;
import com.example.demo.service.CommentoService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ApiCommentoController {

	
	@Autowired
	CommentoService commentoService;
	
	@PostMapping("/commento")
	public ResponseEntity<CommentoResponseDto> storePizza(
			@RequestBody Commento commento, @Valid BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return new ResponseEntity<>(
					new CommentoResponseDto(bindingResult), 
					HttpStatus.BAD_REQUEST
				);
		}
		
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
