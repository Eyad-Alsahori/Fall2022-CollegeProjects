package edu.cuny.csi.csc330.lab3;

import edu.cuny.csi.csc330.util.Randomizer;
import java.util.Arrays;
import java.util.Date;


public class LottoQuickPicker {
//given information
    public final static int DEFAULT_GAME_COUNT = 1;
    private final static String GAME_NAME = "Lotto";
    private final static int SELECTION_COUNT = 6;
    private final static int SELECTION_POOL_SIZE = 59;

 
    //Extra credit
    private long calculateOdds() {
    	long resultS = 1;
    	long resultP = 1;
    	int selectionCount = SELECTION_COUNT;
    	int selectionPoolSize = SELECTION_POOL_SIZE;
    	for (int i = selectionCount; i > 0; i--) {
    	resultS *= i;
    	resultP *= selectionPoolSize;
    	selectionPoolSize--;
    	}
    	return resultP / resultS;
    	}

    
    public LottoQuickPicker() {
        init(DEFAULT_GAME_COUNT);
    }

    
    public LottoQuickPicker(int games) {
        init(games);
    }

    private int [][]ticket;
    private void init(int games) 
	{
		ticket = new int[games][SELECTION_COUNT];
		int nums;
		for(int i = 0; i < games; i++) 
		{
			for(int j = 0; j < SELECTION_COUNT; j++) 
			{
				nums = Randomizer.generateInt(1, SELECTION_POOL_SIZE);
				for (int k=0; k<j; k++)
				{
					if (ticket[i][k] == nums)
						nums = Randomizer.generateInt(1, SELECTION_POOL_SIZE);
				}
				ticket[i][j]=nums;
			}
			Arrays.sort(ticket[i]);
		}
	}
	

     public void displayTicket()
     {
    	 displayHeading();
    	 for(int i = 0; i<ticket.length; i++) {
 			System.out.printf("(%2d)", i+1);
 			for(int j = 0; j < SELECTION_COUNT; j++) 
 			{
 				System.out.printf(" %02d",ticket[i][j]);
 			}
 			System.out.println();
 		}
        displayFooter();
    }

     
    protected  void displayHeading() {
        System.out.println("----------------------------");
        System.out.println("-----------" + GAME_NAME + "------------");
     
 Date current = new Date();
	    System.out.println(" " + current + "\n");	
    }

    
    
    protected void displayFooter() {
    	 System.out.println("");
    	System.out.println("Odds of Winning : 1 in " + calculateOdds());
        System.out.println("---- (c) S.I Corner Deli ----");
        System.out.println("-----------------------------");
    }

   
    public static void main(String[] args) {
        if (args.length > 0) { 
        }
        
        int numberOfGames = 1;
        if(args.length > 0 && Integer.parseInt(args[0]) > 0) {
        numberOfGames = Integer.parseInt(args[0]);
        }

        
        LottoQuickPicker lotto = new LottoQuickPicker(numberOfGames);
        lotto.displayTicket();
    }
} 
