package com.lessons.java.spring.pizzeria.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lessons.java.spring.pizzeria.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * QUERY CUSTOM PER CERCARE L'USER TRAMITE USERNAME;
	 */
	public Optional<User> findByUsername(String username);
}
