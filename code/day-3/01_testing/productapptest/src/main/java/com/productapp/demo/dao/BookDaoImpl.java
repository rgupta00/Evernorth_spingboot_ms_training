package com.productapp.demo.dao;

import org.hibernate.engine.jdbc.BlobImplementer;

import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao {
	@Override
	public List<String> getBooks() {
		log();
		System.out.println("-----hi--------");
		return Arrays.asList("java","rich dad poor dad","java adv");

	}
	public void log(){
		System.out.println("---------log-----------");
	}
}