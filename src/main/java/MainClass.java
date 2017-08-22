import java.io.FileReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class MainClass {
	
	public static void main(String[] args) throws Exception {
		MainClass m = new MainClass();
		m.parseXML();
	}
	
	public void parseXML() throws Exception{
		String xmlFileName = "/Users/waitroseteam/Documents/workspace/TryXMLParsing/src/main/java/ofOrder.xml";

		InputSource src = new InputSource();
		src.setCharacterStream(new FileReader(xmlFileName));
		
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.parse(src);

		// Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();
        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        XPathExpression expr = xpath.compile("/PublishCustomerOrder/body/customerOrderObject/customerOrder/customerOrderConsignment/customerDeliveryDetails/location/retailstore/retailStoreID");
        String branchIdValue = (String) expr.evaluate(doc, XPathConstants.STRING);
        System.out.println("branchId Value in XML : " +branchIdValue);
        
	}

}

