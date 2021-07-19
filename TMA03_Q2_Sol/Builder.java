import java.util.*;
import ou.*;

/**
 * The class Builder is used to hold data about the builder's 
 * on site  contractors, and their contact details and trade. 
 * 
 * @author Anna Duncan
 * @version 17/04/21 
 */
 public class Builder
 {
    // Q2 a(i)
     //private String contractor; 
   private HashMap<String, Contractor> contractors;
   
   /**
     * Q2 a(ii)
     * Constructor for objects of class Builder
     */
     public Builder()
     {
        super();
       contractors = new HashMap<>();
        
     }
   /**
    * Q2 a (iii)
    * Add contractor method creates an instance of Contractor and then add it to the map 
    * referenced by the instance variable contractors with aReg as the key. The method 
    * overwrites any existing entry for the key aReg.
    */
   public void addContractor(String aReg, String aName, String anAddress, String aTrade)
      
   {  
        Contractor aContractor = new Contractor( aName, anAddress, aTrade);
        contractors.put(aReg, aContractor);
        
   }
   /**
    * Q2 a (iv)
    * For each Contractor held in the collection referenced by contractors, the method 
    * prints that contractor’s record to the standard output, each contractor 
    * record on a separate line.
    */
   public void printContractors()
   {
      for (String i : contractors.keySet()) {
      System.out.println( contractors.get(i));
    }
   }
   /**
    * Q2 b
    * If the registration number is found in the contractors collection then the corresponding 
    * Contractor object is returned, otherwise the method prints a suitable message including 
    * the registration number to the standard output and returns null.
    */
   public String findContractor(String aReg)
   {  
     String value= ""; 
     if (contractors.containsKey(aReg)){
         value = contractors.get(aReg).toString();
      }
     else {
      value = null;
      System.out.println("Sorry registration number " + aReg + " does not exist in our records.");
      }
     return value;
      }
   /**
    * Q2 c
    * The method loops through contractors looking for instances of Contractor 
    * whose trade matches the given argument. As such instances are found, 
    * the method adds these instances of Contractor to the set that will be returned.
    */    
   public Set<Contractor> findContractorsForTrade(String aTrade)
   {
     Set<Contractor> contractorsFound = new HashSet<>();
     for (Contractor c : contractors.values()) {
      if (c.getTrade() == aTrade) {
          contractorsFound.add(c);
      }
    }
    return contractorsFound;
   }
}