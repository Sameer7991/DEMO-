package com.example.EcommerceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.EcommerceAPI.Entities.Product;
import com.example.EcommerceAPI.Entities.UserRegistration;
import com.example.EcommerceAPI.Repo.ProductRepo;
import com.example.EcommerceAPI.Repo.UserRepo;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void run(String... args) throws Exception
	{
		Product product = new Product(1, "Dell", "Dell laptopwith 16GB RAM", 15000, 5);
        productRepo.insert(product);
        
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("Macbook");
        p2.setPrice(65000);
        p2.setDescription("Macbook Laptop with 16GB RAM");
        p2.setQuantity(2);
        productRepo.insert(p2);
        
        Product p3 = new Product();
        p3.setId(3);
        p3.setName("Asur");
        p3.setPrice(45000);
        p3.setDescription("Asur Laptop with 16GB RAM");
        p3.setQuantity(2);
        productRepo.insert(p3);


        Product p4 = new Product();
        p4.setId(4);
        p4.setName("HP");
        p4.setPrice(165000);
        p4.setDescription("HP Laptop with 16GB RAM");
        p4.setQuantity(2);
        productRepo.insert(p4);

       UserRegistration user = new UserRegistration(1, "Majid", "Sama2@gmail.com","i");
        userRepo.save(user);

        UserRegistration user1 = new UserRegistration();
        user1.setId(2);
        user1.setName("Sameer");
        user1.setEmail("Majid123@gmail.com");
        user1.setPassword("i");
        userRepo.save(user1);
        
        UserRegistration user2 = new UserRegistration();
        user2.setId(3);
        user2.setName("Khan");
        user2.setEmail("Zaid@gmail.com");
        user2.setPassword("i");
        userRepo.save(user2);

        UserRegistration user3 = new UserRegistration();
        user3.setId(3);
        user3.setName("Shan");
        user3.setEmail("MAan@gmail.com");
        user3.setPassword("i"); 
        userRepo.save(user3);
        
        UserRegistration user4 = new UserRegistration();
        user4.setId(4);
        user4.setName("Shan");
        user4.setEmail("NDI@gmail.com");
        user4.setPassword("i");
        userRepo.save(user4);
        
        ProductRepo repo = new ProductRepo();
        System.out.println(repo.findAll());
	}

	
	
}


