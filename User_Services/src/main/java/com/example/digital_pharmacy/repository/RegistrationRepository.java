package com.example.digital_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.digital_pharmacy.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>
{
	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId, String password);
}
