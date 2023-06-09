package com.example.demo.pojo;

import java.util.List;

import com.example.demo.auth.pojo.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Foto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "il titolo non può essere vuoto")
	@Size(min = 3, message = "almeno 3 caratteri")
	private String titolo;
	
	@NotBlank(message = "la descrizione non può essere vuota")
	@Size(min = 3, message = "almeno 3 caratteri")
	@Column(columnDefinition = "TEXT")
	private String descrizione;
	
	@NotBlank(message = "l'url non può essere vuota")
	@Column(columnDefinition = "TEXT")
	private String url;
	
	private boolean visibile;
	
	@ManyToMany
	@JsonManagedReference
	private List<Categorie> categorie;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonBackReference
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Foto() { }


	public Foto(
			String titolo,
			String descrizione,
			String url,
			User user) {
		
		
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.url = url;
		this.visibile = true;
		this.user = user;
		
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public boolean isVisibile() {
		return visibile;
	}


	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}


	public List<Categorie> getCategorie() {
		return categorie;
	}


	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Foto [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", url=" + url + ", visibile="
				+ visibile + "]";
	}
	
	
	
}
