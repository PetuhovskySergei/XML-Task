package servlets;

import org.xml.sax.helpers.DefaultHandler;
import entity.Product;
import org.xml.sax.*;

public class SAXPars extends DefaultHandler {
	Product product = new Product(); 
	String thisElement = ""; 
	 
	public Product getResult(){ 
	  return product; 
	} 
	 
	@Override 
	public void startDocument() throws SAXException { 
	  System.out.println("Start parse XML..."); 
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
	  if (thisElement.equals("id")) { 
	     product.setId(new Integer(new String(ch, start, length))); 
	  } 
	  if (thisElement.equals("ProductName")) { 
	     product.setProductName(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("Provider")) { 
	     product.setProvider(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("Model")) { 
	     product.setModel(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("DateOfIssue")) { 
	     product.setDateOfIssue(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("Color")) { 
	     product.setColor(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("Price")) { 
	     product.setPrice(new String(ch, start, length)); 
	  } 
	  
	} 
	 
	@Override 
	public void endDocument() { 
	  System.out.println("Stop parse XML..."); 
	} 
	} 