package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.auth.pojo.Role;
import com.example.demo.auth.pojo.User;
import com.example.demo.auth.service.RoleService;
import com.example.demo.auth.service.UserService;
import com.example.demo.pojo.Foto;
import com.example.demo.service.FotoService;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Autowired
	FotoService fotoService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Foto f1 = new Foto("prova1", "provaprova", "https://www.keblog.it/wp-content/uploads/2021/12/foto-piu-belle-2021-08.jpg");
		
		fotoService.save(f1);
		
		Foto f2 = new Foto("prova2", "provaprovaprova", "https://www.keblog.it/wp-content/uploads/2021/12/foto-piu-belle-2021-08.jpg");
		
		fotoService.save(f2);
		
		
	
		Role roleAdmin = new Role("ADMIN");
		
		
		roleService.save(roleAdmin);
		
		final String pws = new BCryptPasswordEncoder().encode("pws");
		
	
		User userAdmin = new User("admin", pws, roleAdmin);
				
	
		userService.save(userAdmin);
		
		
	}

}
