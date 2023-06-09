package com.example.demo.pojo;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Categorie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToMany(mappedBy = "categorie")
	@JsonBackReference
	private List<Foto> foto;
	
	@NotBlank(message = "il titolo non può essere vuoto")
	@Size(min = 3, message = "almeno 3 caratteri")
	private String titolo;

	
	public Categorie() { }
	
	public Categorie(
			String titolo) {
	
		
	
		this.titolo = titolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", titolo=" + titolo + "]";
	}
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        Categorie other = (Categorie) o;
	        return Objects.equals(id, other.id);
	    }
	    
	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	
	
	
}
