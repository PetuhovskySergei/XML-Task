package project.java.parsing;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import project.java.entity.Product;

public class DOMPars {

	public static void main(String[] args) throws Exception {
	    //Get the DOM Builder Factory
	    DocumentBuilderFactory factory = 
	        DocumentBuilderFactory.newInstance();
	    factory.setValidating(true);
	    
	    //Get the DOM Builder
	    DocumentBuilder builder = factory.newDocumentBuilder();
	 
	    //Load and Parse the XML document
	    //document contains the complete XML as a Tree.
	    Document document = 
	      builder.parse(
	        ClassLoader.getSystemResourceAsStream("project/resources/shop.xml"));
	 
	 
	    List<Product> prodList = new ArrayList<>();
	    NodeList nodeList = document.getDocumentElement().getChildNodes();
	 
	    for (int i = 0; i < nodeList.getLength(); i++) {
	 
	      Node node = nodeList.item(i);
	      if (node instanceof Element) {	        
	        NodeList childNodes = node.getChildNodes();
	        for (int k = 0; k < childNodes.getLength(); k++) {
	          Node bNode = childNodes.item(k);
	          
	          NodeList childBNodes = bNode.getChildNodes();
	          for (int j = 0; j < childBNodes.getLength(); j++) {
	        	  Node cNode = childBNodes.item(j);
	          if (cNode instanceof Element) {
	        	  Product prod = new Product();
	        	  NodeList productChilds = cNode.getChildNodes();
	        	  for (int l = 0; l < productChilds.getLength(); l++){
	        		  Node lastNode = productChilds.item(l);
	            switch (lastNode.getNodeName()) {
	              case "name":
	            	  	prod.setName(lastNode.getTextContent());
	                break;
	              case "producer":
	            	  	prod.setProducer(lastNode.getTextContent());
	                break;
	              case "model":
	            	  	prod.setModel(lastNode.getTextContent());
	                break;
	              case "dateOfIssue":
	            	 SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		                prod.setDateOfIssue(format.parse(lastNode.getTextContent()));
		      		break;
	              case "color":
		                prod.setColor(lastNode.getTextContent());
		            break;
	              case "price":
	            	   	prod.setPrice(new BigDecimal(lastNode.getTextContent()));
		            break;
	              case "notInStock":
		                prod.setNotInStock(lastNode.getTextContent());
		            break;
	            }
	          }
	        	  prod.setCategory(node.getNodeName());
	        	  prod.setSubcategory(bNode.getNodeName());
	        	  prodList.add(prod);
	          }
	          
	          }
	        
	          }
	      }
	 
	    }
	 
	    for (Product prod : prodList) {
	      System.out.println(prod);
	    }
	 
	  }
}