/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettocircolari;

/**
 *
 * @author Jedda_Ibrahim
 */
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List informazioni;

    public Parser() {
        informazioni = new ArrayList();
    }

    public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        String pippo;
        NodeList nodelist;
        String info;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                pippo =  getTextValue((Element)nodelist.item(i),"td");
                //if(element.hasAttribute(info))
                //info = getLink(element);
                
                informazioni.add(pippo);
            }
        }
        return informazioni;
    }
    
        // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag) {
        String tmp = "";
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        
        if (nodelist != null && nodelist.getLength() > 0) {  
                informazioni.add(element);    
            
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                if(element!=null && element.getFirstChild()!=null){
                     tmp += element.getFirstChild().getNodeValue() +" ";
                }
            }
        }
        return tmp;
    }  
    
    // restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }
    
    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }
    
     
  

}