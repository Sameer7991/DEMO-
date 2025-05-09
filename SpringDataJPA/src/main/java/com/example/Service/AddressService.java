package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Address;
import com.example.Repository.AddressRepo;

@Service
public class AddressService {
	
	
	@Autowired
	private AddressRepo addressRepo;
	
	public Address createAddress(Address address){
		return addressRepo.save(address);
	}

	public List<Address> findAllAddress(){
		return addressRepo.findAll();
	}

	
	
}
