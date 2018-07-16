package com.fnx.be.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fnx.be.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
//	@SuppressWarnings("unchecked")
//	User save(User user);
	
	List<User> findById(int id);

	List<User> findByEmail(String email);

}
