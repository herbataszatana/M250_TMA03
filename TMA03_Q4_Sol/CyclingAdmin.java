import java.util.*;
import java.io.*;
import ou.*;

/**
 * Class CyclingAdmin - carries out administrative tasks for a cycling race.
 * 
 * @author 
 * @version
 */
public class CyclingAdmin
{
  
   /* instance variables */
   ArrayList<Cyclist> cyclists = new ArrayList<>(); //Q4b(i)
   
   /* static variables */
   public static final int MIN_RACE_TIME = 6000; 
   
   /**
    * Constructor for objects of class CyclingAdmin
    */
   public CyclingAdmin()
   {
      super();
      //Q4b(i)
      ArrayList<Cyclist> cyclists = new ArrayList<>();
   }
 
   /* instance methods */
   
   /**
   * Clears the cyclists list.
   */   
   public void clear()
   {
      this.cyclists.clear();
   }
   
   /**
    * Qb(ii)
    * Method prompts user to select text file with the cyclist data, reads it 
    * and create an instance of cyclist for each cyclist mentioned in a text file.
    * Method also translates age to race category. 
    */
   public void  readInCyclists()
   {
      
      clear();
      String raceCat = ""; 
      String pathname = OUFileChooser.getFilename();
      File aFile = new File(pathname);
      BufferedReader bufferedFileReader = null;
      
      try
      {
         Scanner lineScanner;
         bufferedFileReader = new BufferedReader(new FileReader(aFile));
         String currentLine = bufferedFileReader.readLine();            
         while (currentLine != null)
         {
            lineScanner = new Scanner(currentLine);
            lineScanner.useDelimiter(",");
            String name = lineScanner.next();
            String age = lineScanner.next(); 
               if (Integer.parseInt(age) < 18) {raceCat = "Junior";}
               else if((18 < Integer.parseInt(age))&& (Integer.parseInt(age)< 40)) {raceCat = "Adult";}
               else if (Integer.parseInt(age) > 40 ) {raceCat = "Veteran";}
            String aName = name;
            String aCat = raceCat;
            cyclists.add(new Cyclist(aName, aCat));   
            currentLine = bufferedFileReader.readLine(); 
         }
      }
      catch (Exception anException)
      {
         System.out.println("Error: " + anException);
      }
      finally
      { 
         try
         {
            bufferedFileReader.close();
         }
         catch (Exception anException)
         {
            System.out.println("Error: " + anException);
         }
      }
   }
   
   /**
    * Q4b(iii)
    * For each cyclist method generates random times. 
    * Times have to be between MIN_RACE_TIME and (MIN_RACE_TIME * 2)
    */
   public void rideRace()
   {
         for (Cyclist cyclist : cyclists)
         {
            Random generator = new Random();
            cyclist.setTime(generator.nextInt((MIN_RACE_TIME + 1)) + MIN_RACE_TIME);
         }
   }
   
   /**
    * Q4d
    * Method displays all race results starting from the fastest to the slowest.
    */
   public void displayResults(){
      List<Cyclist> sortedCyclists = new ArrayList<>(cyclists);

      Collections.sort(sortedCyclists);

      for (Cyclist cyclist : sortedCyclists)
      {

         System.out.println(cyclist.toString());
      
      }
   }
}
