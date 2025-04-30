package com.ranine.applications;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ranine.applications.entities.Application;
import com.ranine.applications.entities.Role;
import com.ranine.applications.entities.User;
import com.ranine.applications.services.AppService;
import com.ranine.applications.services.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ApplicationsApplication implements CommandLineRunner{

	@Autowired
	AppService appService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationsApplication.class, args);
	}
/*
	 @PostConstruct 
	 void init_users() { 
	  //ajouter les rôles 
	  userService.addRole(new Role(null,"ADMIN")); 
	  userService.addRole(new Role(null,"AGENT")); 
	  userService.addRole(new Role(null,"USER")); 
	   
	  //ajouter les users 
	  userService.saveUser(new User(null,"admin","123",true,null)); 
	  userService.saveUser(new User(null,"ranine","123",true,null)); 
	  userService.saveUser(new User(null,"user1","123",true,null)); 
	   
	  //ajouter les rôles aux users 
	  userService.addRoleToUser("admin", "ADMIN"); 
	   
	  userService.addRoleToUser("ranine", "USER"); 
	  userService.addRoleToUser("ranine", "AGENT"); 
	   
	  userService.addRoleToUser("user1", "USER");   
	 }
	*/
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
	}

	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
