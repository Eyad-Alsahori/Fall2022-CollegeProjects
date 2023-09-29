
package edu.cuny.csi.csc330.lab1;
//BizzBuzzGame class
public class BizzBuzzGame {

	//will go 50 MAX_TURNS iterations using the loop shown below
 static private final int MAX_TURNS = 50;
 static private final int BIZZ = 3;
 static private final int BUZZ = 6;
 static private final String[] PLAYERS = {
     "Richard",
     "John",
     "Cynthia",
     "Paul",
     "Jane",
     "George",
     "Patti",
     "Olivia",
     "Brian",
     "Maureen"
 };

//This generateSpokenValue() method will returns one of the following: BIZZ / BUZZ / BIZZ-BUZZ

 static private String generateSpokenValue(int count){
     // count divide by BIZZ and BUZZ
     if(count % BUZZ == 0 && count % BIZZ==0)
     {
         return "BIZZ-BUZZ";
     }
 	//if current count is factor of BIZZ, return "BIZZ" 
     else if(count % BIZZ == 0)
     {
         return "BIZZ";
     }
 	//if current count is factor of BUZZ, return "BUZZ" 
     else if(count % BUZZ == 0)
     {
         return "BUZZ";
     }
     else
     
   // it will return the count value as instructed
     return Integer.toString(count);
     
     }

 static public void goPlay() {
	
	 // using a loop to cycle through MAX_TURNS iterations 
	 int playersLength = PLAYERS.length;
     for(int i=1;i<=MAX_TURNS;i++)
     {
         // getting the name and value
         String names = PLAYERS[(i-1)%playersLength];
         String Value = generateSpokenValue(i);
         System.out.format("%-10s %20s\n",names,Value);
     }
 }
 
 public static void main(String args[]) {
     // start the game
		// im calling goPlay
     BizzBuzzGame.goPlay();
     
 }
}



