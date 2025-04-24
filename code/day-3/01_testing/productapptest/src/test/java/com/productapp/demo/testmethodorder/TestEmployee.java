package com.productapp.demo.testmethodorder;

import org.junit.jupiter.api.*;

public class TestEmployee {

	@Tag(value = "dev")
	@Test
	public void testSave() {
		System.out.println("saving");
	}
	@Tag(value = "dev")
	@Test
	public void testUpdate() {
		System.out.println("update");
	}
	@Tag(value = "test")
	@Test
	public void testGetAll() {
		System.out.println("getAll");
	}
	@Tag(value = "test")
	@Test
	public void testDelete() {
		System.out.println("delete");
	}

}
