package com.productapp.demo.dao;

import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao {
	@Override
	public List<String> getBooks() {
		return Arrays.asList("java","rich dad poor dad","java adv");
	}
}