
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
   // instance variables - replace the example below with your own
   private String firstName;
   private String secondName;

   /**
    * Constructor for objects of class Person
    */
   public Person(String aName, String aSecondName)
   
   {
      this.firstName = aName;
      this.secondName = aSecondName;
   }
   
   public Person(String second)
   {
      this("", second);
   }

   public String getInitials()
   {
      
      return "" + this.firstName.charAt(0) + this.secondName.charAt(0);
   }
   
   /**
    * a public method getName() that returns the full name of the person,
    * formed by concatenating the person's firstName and secondName
    * separated by a space
    */
   public String getName() 
   {
      return this.firstName + " " + this.secondName;
   
   }
   /**
    * a public method printReverse() that returns no value, but prints
    * to the standard output the characters in the full name of the person in
    * reverse order. For example, if the person has the full name
    * "Alice Jones", the method will print "senoJ ecilA" on one
    * line. 
    */
   
   public void printReverse() 
   {
        StringBuilder sb = new StringBuilder(this.getName());  
        System.out.println(sb.reverse());  
   }
   /**
    * Write a public instance method with the signature
    * equals(Person)
    * for the class Person that returns true if the receiver has the same
    * firstName and secondName as the argument.
    */
   public boolean equals(Person other)
   {
      if ((this.firstName == other.firstName) && (this.secondName == other.secondName))
      {
         return true;
      }
      else 
      {  
         return false;
      }
   }
}
