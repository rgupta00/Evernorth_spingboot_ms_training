package com.productapp;

import com.productapp.dto.InfoDto;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

@EnableConfigurationProperties(InfoDto.class)
@EnableAspectJAutoProxy
@SpringBootApplication
public class Productappv1Application implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(Productappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
