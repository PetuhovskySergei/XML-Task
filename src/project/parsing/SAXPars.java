package project.parsing;

import org.xml.sax.helpers.DefaultHandler;

import project.entity.Product;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;

public class SAXPars extends DefaultHandler {
	
	public static void main(String[] args)
    {
        try
        {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
 
            DefaultHandler defaultHandler = new DefaultHandler()
            {
                boolean bName = false;
                boolean bProducer = false;
                boolean bModel = false;
                boolean bDateOfIssue = false;
                boolean bColor = false;
                boolean bPrice = false;
                boolean bNotInStock = false;
 
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
              //      System.out.println("Start element: " + qName);
                    if(qName.equalsIgnoreCase("name")){
                        bName = true;
                    }
                    if(qName.equalsIgnoreCase("producer")){
                        bProducer = true;
                    }
                    if(qName.equalsIgnoreCase("model")){
                        bModel = true;
                    }
                    if(qName.equalsIgnoreCase("dateOfIssue")){
                        bDateOfIssue = true;
                    }
                    if(qName.equalsIgnoreCase("color")){
                        bColor = true;
                    }
                    if(qName.equalsIgnoreCase("price")){
                        bPrice = true;
                    }
                    if(qName.equalsIgnoreCase("notInStock")){
                        bNotInStock = true;
                    }
                }
 
                public void endElement(String uri, String localName, String qName) throws SAXException{
                //    System.out.println("End element: " + qName);
                	
                }
 
                public void characters(char ch[], int start, int length) throws SAXException{
                    if(bName){
                        System.out.println("Name: " + new String(ch, start, length));
                        bName = false;
                    }
                    if(bProducer){
                        System.out.println("Producer: " + new String(ch, start, length));
                        bProducer = false;
                    }
                    if(bModel){
                        System.out.println("Model: " + new String(ch, start, length));
                        bModel = false;
                    }
                    if(bDateOfIssue){
                        System.out.println("Date Of Issue: " + new String(ch, start, length));
                        bDateOfIssue = false;
                    }
                    if(bColor){
                        System.out.println("Color: " + new String(ch, start, length));
                        bColor = false;
                    }
                    if(bPrice){
                        System.out.println("Price: " + new String(ch, start, length));
                        bPrice = false;
                    }
                    if(bNotInStock){
                        System.out.println(new String(ch, start, length));
                        bNotInStock = false;
                    }
                    System.out.println();
                }
                
            };
 
            saxParser.parse("src/resources/shop.xml", defaultHandler);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }
}