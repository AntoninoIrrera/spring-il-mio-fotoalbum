package com.example.demo.api.dto;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.example.demo.pojo.Guida;

public class GuidaResponseDto {

	Guida guida;
	BindingResult bindingResult;
	
	public GuidaResponseDto(Guida guida) {
			
		setGuida(guida);
		}
	public GuidaResponseDto(BindingResult bindingResult) {
		
		setBindingResult(bindingResult);
	}
	public GuidaResponseDto(Guida pizza, BindingResult bindingResult) {
		
		setGuida(pizza);
		setBindingResult(bindingResult);
	}

	
	
	 public Guida getGuida() {
		return guida;
	}
	public void setGuida(Guida guida) {
		this.guida = guida;
	}
	public BindingResult getBindingResult() {
		return bindingResult;
	}
	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}



	private List<String> errors;

	    public GuidaResponseDto(List<String> errors) {
	        this.errors = errors;
	    }

	    public List<String> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<String> errors) {
	        this.errors = errors;
	    }
	
	
	
}
