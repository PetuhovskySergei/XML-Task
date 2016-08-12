package java.dao;

import java.entity.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddProduct {
	
	public List<Product> getProduct() throws Exception {
		 ResultSet rs = /*метод для вывода результата в консоли*/;
		 List<Product> result = new ArrayList<Product>();  
		 while(rs.next()){
			 Product product = new Product();
			 product.setName(rs.getString("name"));
			 product.setProducer(rs.getString("producer"));
			 product.setModel(rs.getString("producer"));
			 product.setDateOfIssue(rs.getDate("dateOfIssue"));
			 product.setColor(rs.getString("color"));
			 product.setPrice(rs.getBigDecimal("price"));
			 product.setNotInStock(rs.getString("notInStock"));
			 result.add(product);
		 } 
		 
		return result;
	}
}
