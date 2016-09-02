package project.java.parsing;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import project.java.entity.Product;
import project.java.modification.DOMMod;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		try{
			StAXPars.main(args);
		} catch (Exception e){
			e.printStackTrace();
		}
	
	*/ 

		try {
			DOMPars.main(args);
			//DOMMod.domMod(null, null, null, null, null, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 
	 /* 	try{
		SAXPars.main(args);
	  	} catch (Exception e) {
	  		e.printStackTrace();
	  	}
	} */
}
}


