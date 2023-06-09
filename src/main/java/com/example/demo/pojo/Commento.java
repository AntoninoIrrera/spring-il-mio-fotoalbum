package com.example.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Commento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "il messaggio non può essere vuota")
	@Size(min = 3, message = "almeno 3 caratteri")
	@Column(columnDefinition = "TEXT")
	private String messaggio;
	
	public Commento() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	@Override
	public String toString() {
		return "Commento [id=" + id + ", messaggio=" + messaggio + "]";
	}
	
	
	
}
