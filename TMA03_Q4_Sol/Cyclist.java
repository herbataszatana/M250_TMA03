/**
 * Class Cyclist - Models a cyclist in a cycling race
 * 
 * @author 
 * @version
 */
public class Cyclist implements Comparable<Cyclist> //Q4c(ii)
{
   /* static variables */
   private static int nextNumber = 0; // Q4a(i)
   /* instance variables */   
   private int number;       // cyclist's number
   private String name;      // cyclist's name
   private String raceCat;   // Junior U18, Adult U40, or Veteran 40 and over
   private int time;         // cyclist's race time in tenths of a second
   
   /**
    * Constructor for objects of class Cyclist
    */
   public Cyclist(String aName, String raceCat)
   {
      this.name = aName;
      this.raceCat  = raceCat;
      this.time = 0;
      //Q4a(ii)
      if (nextNumber == 0)
      {
         number = 1 + nextNumber;
         nextNumber = 1 + number ;
      }
      else 
      {
         number = nextNumber;
         nextNumber = 1 + nextNumber ;
      }
    }
  public Person(String second)
 {
 this("", second);
 } /* instance methods */
   /**
    * Returns the receiver's number
    */
   public int getNumber()
   {
      return this.number;
   }
   
   /**
    * Returns the receiver's name
    */
   public String getName()
   {
      return this.name;
   }
   
   /**
    * Sets the receiver's name
    */
   public void setName(String aName)
   {
      this.name = aName;
   } 

    /**
     * @return the race category
     */
    public String getRaceCat()
    {
        return raceCat;
    }

    /**
     * @param raceCat the race category to set
     */
    public void setRaceCat(String raceCat)
    {
        this.raceCat = raceCat;
    }
   
    /**
    * Returns the receiver's time
    */
    public int getTime()
    {
      return this.time;
    }
   
    /**
    * Sets the receiver's time in tenths of a second
    */
    public void setTime(int aTime)
    {
      this.time = aTime;
    }
   
    /**
    * Q4 c i
    * Returns a string representation of cyclist using format srting:
    * "%s \t %d mins %.1f secs \t %s"
    */
    public String toString()
    {
         int raceTime = getTime();
         int minutes = raceTime / 600;
         double number = 600.0;
         double seconds = raceTime/ number;
         String displayTime = String.format("%s \t %d mins %.1f secs \t %s", name, minutes, seconds, raceCat); 
         return displayTime; 
    }
   
    /**
    * Q4 c(ii)
    * Method sort cyclists in ascending order of their time.
    */

      public int compareTo(Cyclist anotherCyclist)
    {
     return (this.getTime() - anotherCyclist.getTime());
    }
   
   }
   


