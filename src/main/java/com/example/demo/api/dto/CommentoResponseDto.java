package com.example.demo.api.dto;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.example.demo.pojo.Commento;

public class CommentoResponseDto {

	Commento commento;
	BindingResult bindingResult;
	
	public CommentoResponseDto(Commento commento) {
			
		setCommento(commento);
		}
	public CommentoResponseDto(BindingResult bindingResult) {
		
		setBindingResult(bindingResult);
	}
	public CommentoResponseDto(Commento commento, BindingResult bindingResult) {
		
		setCommento(commento);
		setBindingResult(bindingResult);
	}

	



	public Commento getCommento() {
		return commento;
	}
	public void setCommento(Commento commento) {
		this.commento = commento;
	}
	public BindingResult getBindingResult() {
		return bindingResult;
	}
	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}





	private List<String> errors;

	    public CommentoResponseDto(List<String> errors) {
	        this.errors = errors;
	    }

	    public List<String> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<String> errors) {
	        this.errors = errors;
	    }
	
	
	
}
