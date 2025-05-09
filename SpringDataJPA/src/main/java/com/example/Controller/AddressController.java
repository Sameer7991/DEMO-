package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entities.Address;
import com.example.Service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public  List<Address> getAllAddress(){
		return addressService.findAllAddress();
	}
	
	 @PostMapping("/add")
	    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
	        Address newAddress = addressService.createAddress(address);
	        return ResponseEntity.ok(newAddress);
	    }
	
	
	
}
