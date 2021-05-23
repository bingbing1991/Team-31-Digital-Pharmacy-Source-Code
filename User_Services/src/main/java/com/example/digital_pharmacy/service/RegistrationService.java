package com.example.digital_pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digital_pharmacy.model.User;
import com.example.digital_pharmacy.repository.RegistrationRepository;

@Service
public class RegistrationService
{
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User saveUser(User user)
	{
		return registrationRepository.save(user);
	}
	
	public User findUserByEmailId(String emailId)
	{
		User foundUser = registrationRepository.findByEmailId(emailId);
		return foundUser;
	}
	
	public User findUserByEmailIdAndPassword(String emailId, String password)
	{
		User foundUser = registrationRepository.findByEmailIdAndPassword(emailId, password);
		return foundUser;
	}
	
}
