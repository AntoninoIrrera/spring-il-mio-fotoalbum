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

import com.example.demo.api.dto.GuidaResponseDto;
import com.example.demo.pojo.Guida;
import com.example.demo.service.GuidaService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ApiGuidaController {

	@Autowired
	GuidaService guidaService;
	
	@PostMapping("/guida")
	public ResponseEntity<GuidaResponseDto> storePizza(
			@RequestBody Guida guida, @Valid BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return new ResponseEntity<>(
					new GuidaResponseDto(bindingResult), 
					HttpStatus.BAD_REQUEST
				);
		}
		
		guida = guidaService.save(guida);
		
		return new ResponseEntity<>(
				new GuidaResponseDto(guida), 
				HttpStatus.OK);	
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<GuidaResponseDto> handleConstraintViolationException(ConstraintViolationException ex) {
	    
	    List<String> errors = ex.getConstraintViolations()
	            .stream()
	            .map(ConstraintViolation::getMessage)
	            .collect(Collectors.toList());

	   
	    return new ResponseEntity<>(
	            new GuidaResponseDto(errors),
	            HttpStatus.BAD_REQUEST
	    );
	}
	
}
