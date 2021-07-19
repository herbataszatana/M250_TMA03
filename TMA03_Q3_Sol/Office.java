import java.util.*;
import ou.*;
/**
 * Write a description of class Office here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Office
{
   // Q3 b 1
   HashMap<String,Set<String>> employeesByOffice;
   Set<String> employees = new HashSet<>();
    
   /**
    * Constructor for objects of class Office
    */
   public Office()
   {
      // Q3 b 2
      employeesByOffice = new HashMap<>();
      
   }
    
   /**
    * Q3 b 2
    * Method to add some test data.
    */public void addEmployee()
   {
      Set<String> employees = new HashSet<>();
      employees.add("Charlie Kelly");
      employees.add("Deandra Reynolds");
      employees.add("Dennis Reynolds");
      employees.add("Ronald MacDonald");
      employees.add("Frank Reynolds");
      employeesByOffice.put("Philadelphia",employees);
      employees = new HashSet<>();
      employees.add("Michael Scott");
      employees.add("Jim Halpert");
      employees.add("Pam Beesly");
      employees.add("Dwight Schrute");
      employeesByOffice.put("Scranton", employees);
     
   }
   
   /**
    * Q3 c
    * Method iterate each office and prints out the employees hired at each location. 
    * It takes no argument and returns no value.
    */

   public void printMap() {
   for (String eachOffice : employeesByOffice.keySet()) 
      { 
         Set employees = employeesByOffice.get(eachOffice);
         System.out.println(employees + " are based at the " + eachOffice + " office. ");
         
      }
   }
   
   /**
    * Q3 c
    * Checks if the office already exists if it does it
    * prints out who works there, or informs that the office does not 
    * exist.
    */
   public void printMapValue(String anOffice) 
   {
      if (employeesByOffice.containsKey(anOffice)){
        //String value = employeesByOffice.get(anOffice).toString();
        System.out.println("Employees working at the " + anOffice + " are "+ employees);
      }
     else {
      
      System.out.println("Sorry coundn't find " + anOffice + " office.");
      }
   }
   
    /**
    * Q3 c 
    * After taking office and a new employee's name arguments, method either
    * replaces employess in existing office or creates brand new office 
    * with the new staff.
    */
   public void addMapEntry(String officeName, String newEmployee) 
   {
     employees.add(newEmployee);
     employeesByOffice.put(officeName, employees);
     
   }

   /**
    * Q3 d
    * Method checks if selected office exists, if it doesn't it returns false, 
    * if it does office is being removed and true is being returned.
    */
   public boolean deleteEntry(String localisation)
   {
      if (employeesByOffice.containsKey(localisation))
      {
         employeesByOffice.remove(localisation);
         return true;
      }
      else 
         {
            return false;
         }
      
   }
   
   /** Q3 d
    * Method adds new employee to the specific office.
    */
   public void addToValueAtKey(String office, String name) 
   {  
      Set employees = employeesByOffice.get(office) ;
      employees.add(name);
      employeesByOffice.put(office, employees);
      System.out.println(name + " has been successfully added to the " + office + " office.");
   }
   
   /** Q3 d
    * Method deletes specific employees working at the selected office.
    */
   
   public void deleteFromValueAtKey(String office, String value) 
   {  Set beforeDel = employeesByOffice.get(office);
      if ((employeesByOffice.containsKey(office)) && (beforeDel.contains(value)))
         { 
             Set employees = employeesByOffice.get(office);
             employees.remove(value);
             Set updatedEmployees = employeesByOffice.get(office);
             employeesByOffice.put(office, employees);
             System.out.println(value + " has been successfully removed from the " + office + " office.");
          }
      else 
         {
            System.out.println(value + " is not working at the " + office + " office.");
         }    
   }      
}