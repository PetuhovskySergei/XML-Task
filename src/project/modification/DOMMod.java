package project.modification;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DOMMod{
		public static void domMod(String name, String producer, String model, String dateOfIssue, String color, String price) {
			try
	        {
	
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    Document document = documentBuilder.parse("src/resources/shop.xml");
	
	    Node shop = document.getFirstChild();
    
    
		Node category = document.getElementsByTagName("technology").item(0);
		shop.appendChild(category);
 
		Node subcategory = document.getElementsByTagName("phone").item(0);
		category.appendChild(subcategory);
    
        Element product = document.createElement("product");
        subcategory.appendChild(product);

         
         Element nname = document.createElement("name");
         nname.appendChild(document.createTextNode("New"));
         product.appendChild(nname);

         Element nproducer = document.createElement("producer");
         nproducer.appendChild(document.createTextNode("New"));
         product.appendChild(nproducer);
         
         Element nmodel = document.createElement("model");
         nmodel.appendChild(document.createTextNode("New"));
         product.appendChild(nmodel);
         
         Element ndateOfIssue = document.createElement("dateOfIssue");
         ndateOfIssue.appendChild(document.createTextNode("01-01-2011"));
         product.appendChild(ndateOfIssue);
         
         Element ncolor = document.createElement("color");
         ncolor.appendChild(document.createTextNode("New"));
         product.appendChild(ncolor);
         
         Element nprice = document.createElement("price");
         nprice.appendChild(document.createTextNode("1000"));
         product.appendChild(nprice);

         
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource domSource = new DOMSource(document);
         StreamResult streamResult = new StreamResult(new File("src/resources/shop.xml"));  

         transformer.transform(domSource, streamResult);
         System.out.println("Файл сохранен!");
		 }
        catch (ParserConfigurationException pce)
        {
            System.out.println(pce.getLocalizedMessage());
            pce.printStackTrace();
        }
        catch (TransformerException te)
        {
            System.out.println(te.getLocalizedMessage());
            te.printStackTrace();
        }	  
		catch (IOException ioe)
	    {
	        System.out.println(ioe.getLocalizedMessage());
	        ioe.printStackTrace();
	    }
	    catch (SAXException sae)
	    {
	        System.out.println(sae.getLocalizedMessage());
	        sae.printStackTrace();
	    }
	}
}
