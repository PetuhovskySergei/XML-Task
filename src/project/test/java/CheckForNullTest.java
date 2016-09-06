package project.test.java;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import project.java.entity.Product;

public class CheckForNullTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	@Test
	public void checkNameForNullTest(){
		Product prod = new Product();
		prod.setName("name");
		assertNotNull("Name is Null", prod.getName());
	}
	
//	@Test
//	public void checkNameForNullNegativeTest(){
//		Product prod = new Product();
//		prod.setName(null);
//		assertNotNull("Name is Null", prod.getName());
//	}
	
	@Test
	public void checkProducerForNullTest(){
		Product prod = new Product();
		prod.setProducer("name");
		assertNotNull("Name is Null", prod.getProducer());
	}
	
//	@Test
//	public void checkProducerForNullNegativeTest(){
//		Product prod = new Product();
//		prod.setProducer(null);
//		assertNotNull("Name is Null", prod.getProducer());
//	}
	
	@Test
	public void checkModelForNullTest(){
		Product prod = new Product();
		prod.setModel("name");
		assertNotNull("Name is Null", prod.getModel());
	}
	
//	@Test
//	public void checkModelForNullNegativeTest(){
//		Product prod = new Product();
//		prod.setModel(null);
//		assertNotNull("Name is Null", prod.getModel());
//	}
	
	@Test
	public void checkDateOfIssueForNullTest(){
		Product prod = new Product();
		prod.setDateOfIssue(new Date(11-11-2012));
		assertNotNull("Date is Null", prod.getDateOfIssue());
	}
	
//	@Test
//	public void checkDateOfIssueForNullNegativeTest(){
//		Product prod = new Product();
//		prod.setDateOfIssue(null);
//		assertNotNull("Date is Null", prod.getDateOfIssue());
//	}
	
	@Test
	public void checkColorForNullTest(){
		Product prod = new Product();
		prod.setColor("Black");
		assertNotNull("Color is Null", prod.getColor());
	}
	
//	@Test
//	public void checkColorForNullNegativeTest(){
//		Product prod = new Product();
//		prod.setColor(null);
//		assertNotNull("Color is Null", prod.getColor());
//	}
	
	@Test
	public void checkPriceForNullTest(){
		Product prod = new Product();
		prod.setPrice(new BigDecimal(1));
		assertNotNull("Price is Null", prod.getPrice());
	}
		
//	@Test
//	public void checkPriceForNullNegativeTest(){
//		Product prod = new Product();
//		prod.setPrice(null);
//		assertNotNull("Price is Null", prod.getPrice());
//	}
	
}
