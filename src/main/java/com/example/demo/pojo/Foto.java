package com.example.demo.pojo;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.auth.pojo.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
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
	
//	@NotBlank(message = "l'url non può essere vuota")
//	@Column(columnDefinition = "TEXT")
//	private String url;
	
	@Lob
	@Column(length=16777215)
	@JsonIgnore
	private byte[] image;
	
	@Transient
	@JsonIgnore
	MultipartFile mpImage;
	
	private boolean visibile;
	
	@ManyToMany
//	@JsonManagedReference
	private List<Categorie> categorie;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonBackReference
	private User user;
	
	@OneToMany(mappedBy = "foto")
	@JsonManagedReference
	private List<Commento> commento;
	
	
	public List<Commento> getCommento() {
		return commento;
	}


	public void setCommento(List<Commento> commento) {
		this.commento = commento;
	}


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
			User user) {
		
		
		this.titolo = titolo;
		this.descrizione = descrizione;
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


	public boolean hasImage() {
		
		return getImage() != null;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public boolean hasMpImage() {
		
		return getMpImage() != null;
	}
	public MultipartFile getMpImage() {
		return mpImage;
	}
	public void setMpImage(MultipartFile mpImage) {
		
		try {
			
			setImage(mpImage.getBytes());
			
			this.mpImage = mpImage;
		} catch (IOException e) { }
	}
	@JsonIgnore
	public String getREImage() {
		
		return Base64.getEncoder().encodeToString(getImage());
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
		return "Foto [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", visibile="
				+ visibile + "]";
	}
	
	
	
}
