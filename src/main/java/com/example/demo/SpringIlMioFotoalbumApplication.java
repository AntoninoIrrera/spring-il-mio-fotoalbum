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
		
		
		
		
	
		Role roleSuperAdmin = new Role("SUPERADMIN");
		
		
		roleService.save(roleSuperAdmin);
		
		final String pws = new BCryptPasswordEncoder().encode("pws");
		
	
		User userSuperAdmin = new User("super admin", pws, roleSuperAdmin);
				
	
		userService.save(userSuperAdmin);
		
		
		Role roleAdmin = new Role("ADMIN");
		
		
		roleService.save(roleAdmin);
		
		
	
		User userAdmin1 = new User("admin1", pws, roleAdmin);
				
	
		userService.save(userAdmin1);
		
		User userAdmin2 = new User("admin2", pws, roleAdmin);
		
		
		userService.save(userAdmin2);
		
		User userAdmin3 = new User("admin3", pws, roleAdmin);
		
		
		userService.save(userAdmin3);
		
		Foto f1 = new Foto("prova1", "provaprova", "https://www.keblog.it/wp-content/uploads/2021/12/foto-piu-belle-2021-08.jpg",userAdmin1);
		
		fotoService.save(f1);
		
		Foto f2 = new Foto("prova2", "provaprovaprova", "https://www.keblog.it/wp-content/uploads/2021/12/foto-piu-belle-2021-08.jpg",userAdmin2);
		
		fotoService.save(f2);
		
		
	}

}
