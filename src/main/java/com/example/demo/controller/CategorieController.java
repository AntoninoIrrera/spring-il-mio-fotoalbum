package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Categorie;
import com.example.demo.pojo.Foto;
import com.example.demo.service.CategorieService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class CategorieController {

	@Autowired
	CategorieService categorieService;
	
	
	@GetMapping("/categorie")
	public String index(Model model) {
		
		List<Categorie> categorie = categorieService.findAll();
		
		model.addAttribute("categorie", categorie);
		
		return "categorieIndex";
	}
	
	@GetMapping("/categorie/create")
	public String create(Model model) {
		
		model.addAttribute("categorie",new Categorie());
		
		return "createFormCategorie";
	}
	
	@PostMapping("/categorie/create")
	public String store(@Valid @ModelAttribute Categorie categorie, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
//			for(ObjectError err : bindingResult.getAllErrors()) {
//				System.out.println(err.getDefaultMessage());
//			}
			
			model.addAttribute("categorie",categorie);
			model.addAttribute("errori",bindingResult);
			
			return "createFormCategorie";
		}
		
		
		categorieService.save(categorie);
		
		return "redirect:/admin/foto";
	}
	
	
	@GetMapping("/categorie/delete/{id}")
	public String delete(
			@PathVariable int id
		) {
		
		Optional<Categorie> categorieOpt = categorieService.findById(id);
		Categorie categorie = categorieOpt.get();
		
		if(categorie.getFoto().size() != 0) {
			
			for(Foto f : categorie.getFoto()) {
				
				f.getCategorie().remove(categorie);
				
			}
			
		}
		
		categorieService.delete(categorie);
		
		return "redirect:/admin/foto";
	}
	

	@GetMapping("/categorie/update/{id}")
	public String edit(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Categorie> categorieOpt = categorieService.findById(id);
		Categorie categorie = categorieOpt.get();
		model.addAttribute("categorie", categorie);
		
		return "updateFormCategorie";
	}
	@PostMapping("/categorie/update/{id}")
	public String update(
			  @Valid
		      @ModelAttribute Categorie categorie,
		      BindingResult bindingResult,
		      @PathVariable int id,
		      Model model
			
			
		) {
		
		
		if(bindingResult.hasErrors()) {
			
			
			
			model.addAttribute("categorie",categorie);
			model.addAttribute("errori",bindingResult);
			
			return "updateFormCategorie";
		}
		
		
		
		categorieService.save(categorie
				);
		
		return "redirect:/admin/foto";
	}
}
	