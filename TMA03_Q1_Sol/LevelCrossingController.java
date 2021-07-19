import ou.*;
/**
 * LevelCrossingController for TMA03Q1.
 * 
 * @author M250 Module Team
 * @version 1.0
 */
public class LevelCrossingController
{  
   private Light topLeft;
   private Light topRight;
   private Light bottom;
   private boolean trainComing;
   private int state; //The appropriate sequence of light depending on a state
   final static int MIN_REPEATS = 4; //Q1 D (i)

   LevelCrossingController(Light l, Light r, Light b)
   {
      this.topLeft = l;
      this.topRight = r;
      this.bottom = b;
      this.setPositions();
      state = 0; // Q1 C (iii)
      trainComing = false;
      this.colourAllLights();
   }
   /**
    * Question C (i)
    * Public instance method which takes no argument and returns no value. 
    * If trainComing is true then it should change the value of state.
    */
   public void changeState(){
      
      if (trainComing == true) {
         if (state == 3){
            state = state - 1;
         }
         else if ((0 <= state)&&(state<3)) {
            state = state + 1;
         }}
      else {
            state = 0;
       }
   }   
   
   
    /**
    * Q1 C(ii)
    * Public instance method which takes no argument and returns no value. 
    * This method uses the value of state to determine what colour each of the three lights should 
    * be set to.
    */
    public void colourAllLights() {
      if (state == 0) {
         this.colourLight(bottom, OUColour.BLACK );
         this.colourLight(topLeft, OUColour.BLACK );
         this.colourLight(topRight, OUColour.BLACK );
      } 
      else if (state == 1) {
         this.colourLight(bottom, OUColour.ORANGE );
         this.colourLight(topLeft, OUColour.BLACK );
         this.colourLight(topRight, OUColour.BLACK );         
      }
      
      else if (state == 2) {
         this.colourLight(bottom, OUColour.BLACK );
         this.colourLight(topLeft, OUColour.RED );
         this.colourLight(topRight, OUColour.BLACK );         
      }
      else if (state == 3) {
         this.colourLight(bottom, OUColour.BLACK );
         this.colourLight(topLeft, OUColour.BLACK );
         this.colourLight(topRight, OUColour.RED );         
      }
    }
   
    /**
     * @return trainComing
     */
    public boolean getTrainComing()
    {
        return trainComing;
    }
    
    /**
     * 
     */
    public void colourLight(Light light, OUColour colour)
    {
         light.setColour(colour);
    }
    
    /**
     * @param trainComing
     * setter for trainComing
     */
    public void setTrainComing(boolean trainComing)
    {
        this.trainComing = trainComing;
    }
      
    /**
    * Sets the positions of the lights.
    */
    private void setPositions() 
    {
      this.bottom.setXPos(100);
      this.bottom.setYPos(200);      
      this.topLeft.setXPos(0);
      this.topLeft.setYPos(100);      
      this.topRight.setXPos(200);
      this.topRight.setYPos(100);
    }   
  
    /**
    * Find out how many times red lights should flash at the crossing.
    * Simulates length of train at crossing.
    */   
    public static int findNumRepeats()
    {
       int repeats = 0;
       boolean exep = false;
       String timesAsString = 
          OUDialog.request("How many times should the red lights"
          + " flash? ("
          + LevelCrossingController.MIN_REPEATS
          + " or over times)");

       if (timesAsString != null){
          //Q1 D (ii) 1       
          try{ 
             repeats = Integer.parseInt(timesAsString);
                        
             }
          catch (Exception e){ 
              System.out.println("Something went wrong. Please enter integer");
              exep = true;
             }
          // Q1 D (ii) 2
          if ((exep == false)&&(repeats < LevelCrossingController.MIN_REPEATS - 1)){
               System.out.println("The red lights should flash at least " + LevelCrossingController.MIN_REPEATS + " times"); 
              }
       }
       return repeats;
      }
   
    /**
    * Causes execution to pause for a number of milliseconds.
    */
    public static void delay(int time)
    {
       try
       {
          Thread.sleep(time); 
       }
       catch (Exception e)
       {
          System.out.println(e);
       } 
    }
    /**
     * Question 1 E 
     * Method which takes no arguments and returns no value. It informs user if train is approaching and what is the
     * position the barrier. It flashes lights for number of user inputs. Then turns off lights and informs user about
     * position of the barrier
     */
    public void doTrainApproaching()
    {
       System.out.println("Train approaching");
       delay(1500);
       setTrainComing(true);
       state = 0;
       changeState();
       delay(1500);
       colourAllLights();
       System.out.println("Barrier lowered");
       delay(1500);
       int numRepeats = findNumRepeats();
       for (int n = numRepeats + 1 ; n > 0; n = n - 1){
         changeState();
         delay(500);
         colourAllLights();
            if (n == 1){
               setTrainComing(false);
               changeState();
               colourAllLights();
               delay(1500);
               System.out.println("Barrier raised");
            }
         } 
       }
}


