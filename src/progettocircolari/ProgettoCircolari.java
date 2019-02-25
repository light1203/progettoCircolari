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
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ProgettoCircolari{

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        List lista = null;
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("inserisci file");
        
        String percroso=reader.next();
        
        Parser dom = new Parser();
        
        try
        {
            lista = dom.parseDocument(percroso);
            
            System.out.println("Numero di informazioni: " + lista.size());
            
            for(int i=0;i<lista.size();i++)
            {
                System.out.println(lista.get(i).toString());
            }
            
            
           System.out.println("0)ESCI");
           System.out.println("1)filtra in base al giorno");
           System.out.println("2)filtra in base al docente");
           
           String scelta=reader.next();
           
           while(!scelta.equals("0"))
           {
               if(scelta.equals("1"))
               {
                   System.out.println("inserisci il cognome del docente");
                   String docente=reader.next();
                   
                   System.out.println("RISULTATO RICERCA:");
                   
             for(int i=0;i<lista.size();i++)
            {
               String parts[]=lista.get(i).toString().split(" ");
               
                   /*if(parts[1].equals(docente))
                   {
                       System.out.println(lista.get(i).toString());
                   }
                */
                   
               System.out.println(parts[0]);
               System.out.println(parts[1]);
               System.out.println(parts[2]);
            }
                   
               }
               
                if(scelta.equals("2"))
               {
                   System.out.println("inserisci il giorno della settimana");
                   String giorno=reader.next();
                   
                System.out.println("RISULTATO RICERCA:");
                   
             for(int i=0;i<lista.size();i++)
            {
               if(lista.get(i).toString().contains("giorno"))
               {
                   System.out.println(lista.get(i).toString());
               }
            }
               }
                
           System.out.println("0)ESCI");
           System.out.println("1)filtra in base al giorno");
           System.out.println("2)filtra in base al docente");
           
            scelta=reader.next();
           }
        } 
        
        catch (ParserConfigurationException | SAXException | IOException exception)
        {
            System.out.println("Errore!");
        }
  

    }
   
}
