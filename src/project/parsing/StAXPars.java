package project.parsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXPars {
	public static void main(String[] args) {
	      boolean bName = false;
	      boolean bProducer = false;
	      boolean bModel = false;
	      boolean bDateOfIssue = false;
	      boolean bColor = false;
	      boolean bPrice = false;
	      boolean bNotInStock = false;
	      try {
	         XMLInputFactory factory = XMLInputFactory.newInstance();
	         XMLEventReader eventReader =
	         factory.createXMLEventReader(
	            new FileReader("../src/resources/shop.xml"));

	            while(eventReader.hasNext()){
	               XMLEvent event = eventReader.nextEvent();
	               switch(event.getEventType()){
	                  case XMLStreamConstants.START_ELEMENT:
	                     StartElement startElement = event.asStartElement();
	                     String qName = startElement.getName().getLocalPart();
	                     if (qName.equalsIgnoreCase("product")) {
	                        System.out.println("Start Element : product");
	                        Iterator<Attribute> attributes = startElement.getAttributes();
	                        String rollNo = attributes.next().getValue();
	                        System.out.println("Roll No : " + rollNo);
	                     } else if (qName.equalsIgnoreCase("name")) {
	                        bName = true;
	                     } else if (qName.equalsIgnoreCase("producer")) {
	                        bProducer = true;
	                     } else if (qName.equalsIgnoreCase("model")) {
	                        bModel = true;
	                     } else if (qName.equalsIgnoreCase("dateOfIssue")) {
	                        bDateOfIssue = true;
	                     } else if (qName.equalsIgnoreCase("color")) {
		                        bColor = true;
		                 } else if (qName.equalsIgnoreCase("price")) {
		                        bPrice = true;
		                 } else if (qName.equalsIgnoreCase("notInStock")) {
		                        bNotInStock = true;
		                 }		
	                     break;
	                  case XMLStreamConstants.CHARACTERS:
	                     Characters characters = event.asCharacters();
	                     if(bName){
	                        System.out.println("Name: " 
	                        + characters.getData());
	                        bName = false;
	                     }
	                     if(bProducer){
	                        System.out.println("Producer: " 
	                        + characters.getData());
	                        bProducer = false;
	                     }
	                     if(bModel){
	                        System.out.println("Model: " 
	                        + characters.getData());
	                        bModel = false;
	                     }
	                     if(bDateOfIssue){
	                        System.out.println("Date of issue: " 
	                        + characters.getData());
	                        bDateOfIssue = false;
	                     }
	                     if(bColor){
		                    System.out.println("Color: " 
		                    + characters.getData());
		                    bColor = false;
		                 }
	                     if(bPrice){
		                    System.out.println("Price: " 
		                    + characters.getData());
		                    bPrice = false;
		                 }
	                     if(bNotInStock){
		                    System.out.println(characters.getData());
		                    bNotInStock = false;
		                 }
	                     break;
	                  case  XMLStreamConstants.END_ELEMENT:
	                     EndElement endElement = event.asEndElement();
	                     if(endElement.getName().getLocalPart().equalsIgnoreCase("product")){
	                        System.out.println("End Element : product");
	                        System.out.println();
	                     }
	                     break;
	               }		    
	            }
	         } catch (FileNotFoundException e) {
	            e.printStackTrace();
	         } catch (XMLStreamException e) {
	            e.printStackTrace();
	      }
	   }
	}