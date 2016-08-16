package project.parsing;

import org.xml.sax.helpers.DefaultHandler;

import project.entity.Product;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xml.sax.*;

public class SAXPars extends DefaultHandler {
	
	Product product = new Product(); 
	String thisElement = ""; 
	 
	public Product getResult(){ 
	  return product; 
	} 
	 
	@Override 
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException { 
	  thisElement = qName;  
	} 
	 
	@Override 
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException { 
	  thisElement = ""; 
	} 
	 
	@Override 
	public void characters(char[] ch, int start, int length) throws SAXException {  
	 
	  if (thisElement.equals("name")) { 
	     product.setName(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("producer")) { 
	     product.setProducer(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("model")) { 
	     product.setModel(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("dateOfIssue")) {
		  String strDate = new String(ch, start, length);
		  SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
	     try {
			product.setDateOfIssue(format.parse(strDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	  } 
	  if (thisElement.equals("color")) { 
	     product.setColor(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("price")) { 
	     product.setPrice(new BigDecimal(ch, start, length)); 
	  }
	  if (thisElement.equals("notInStock")) { 
		     product.setNotInStock(new String(ch, start, length)); 
		  } 
	  
	} 
} 
