package com.lessons.java.pizzeria.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lessons.java.spring.pizzeria.model.Role;
import com.lessons.java.spring.pizzeria.model.User;

/*
 * CLASSE CHE IMPLEMENTA L'INTERFACCIA "UserDetails";
 * CONTIENE I METODI PER RISALIRE ALLE INFORMAZIONI DELL'UTENTE LOGGATO;
 */
public class DatabaseUserDetails implements UserDetails{

	//PROPRIETA' USER LOGGATO;
	private final Integer id;
	private final String username;
	private final String password;
	private final Set<GrantedAuthority> authorities;
	
	//COSTRUTTORE
	public DatabaseUserDetails(User user) {
		
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		
		//PER OGNI RUOLO CHE HA UN UTENTE,AGGIUNGILO NEL SET AUTHORITY;
		authorities = new HashSet<GrantedAuthority>();
		
		for(Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public Integer getId() {
		return id;
	}

}
