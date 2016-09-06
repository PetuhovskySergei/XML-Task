package project.test.java;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import project.java.entity.Product;



public class AddDataForProductTest {

	@Test
	public void addNameTest() {
		Product prod = new Product();
		prod.setName("Name");
		assertEquals("Name", prod.getName());
	}
	/*
	@Test
	public void addNameNegativeTest1() {
		Product prod = new Product();
		int test = 11;
		prod.setName(String.valueOf(test));
		assertEquals("Invalid type of data","Name", prod.getName());
	}
	
	@Test
	public void addNameNegativeTest2() {
		Product prod = new Product();
		Date test = new Date(11-10-2007);
		prod.setName(String.valueOf(test));
		assertEquals("Invalid type of data","Name", prod.getName());
	}
	*/
	@Test
	public void addProducerTest() {
		Product prod = new Product();
		prod.setProducer("Producer");
		assertEquals("Producer", prod.getProducer());
	}
	
	@Test
	public void addModelTest() {
		Product prod = new Product();
		prod.setModel("AB123");
		assertEquals("AB123", prod.getModel());
	}
	
	@Test
	public void addDateOfIssueTest() {
		Product prod = new Product();
		prod.setDateOfIssue(new Date(11-10-2013));
		assertEquals(new Date(11-10-2013), prod.getDateOfIssue());
	}
	
	@Test
	public void addColorTest() {
		Product prod = new Product();
		prod.setColor("White");
		assertEquals("White", prod.getColor());
	}
	
	@Test
	public void addPriceTest() {
		Product prod = new Product();
		prod.setPrice(new BigDecimal(100));
		assertEquals(new BigDecimal(100), prod.getPrice());
	}
	/*
	@Test
	public void addPriceNegativeTest() {
		Product prod = new Product();
		String test = "Test";
		assertEquals(new BigDecimal(100), test); //must be prod.getPrice()
	}*/
}
	