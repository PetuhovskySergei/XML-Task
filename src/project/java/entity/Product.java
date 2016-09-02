package project.java.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	
	private String category;
	private String subcategory;
	private String name;
	private String producer;
	private String model;
	private Date dateOfIssue;
	private String color;
	private BigDecimal price;
	private String notInStock;
	
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSubcategory() {
			return subcategory;
		}
		public void setSubcategory(String subcategory) {
			this.subcategory = subcategory;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getProducer() {
			return producer;
		}
		public void setProducer(String producer) {
			this.producer = producer;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public Date getDateOfIssue() {
			return dateOfIssue;
		}
		public void setDateOfIssue(Date dateOfIssue) {
			this.dateOfIssue = dateOfIssue;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public String getNotInStock() {
			return notInStock;
		}
		public void setNotInStock(String notInStock) {
			this.notInStock = notInStock;
		}
		@Override
		public String toString() {
			return "Product [category: " + category + "  subcategory: " + subcategory + "  \n name: " + name + "  \n producer: "
					+ producer + "  \n model: " + model + "  \n Date Of Issue: " + dateOfIssue + "  \n color: " + color + "  \n price: "
					+ price + "  \n Not In Stock: " + notInStock + "]\n";
		}
}