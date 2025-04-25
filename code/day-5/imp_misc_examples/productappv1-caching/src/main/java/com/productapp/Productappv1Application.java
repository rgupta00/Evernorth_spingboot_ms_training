package com.productapp;

import com.productapp.dto.InfoDto;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.math.BigDecimal;

@EnableConfigurationProperties(InfoDto.class)
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class Productappv1Application implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepo.save(new Product("Laptop", new BigDecimal(10000)));
		productRepo.save(new Product("Mobile", new BigDecimal(5000)));
	}
}
