/* Programmer: Shannon Riegle
 * Date: October 1st, 2018
 * Main Driver for Yahtzee Program
 */
 
 import java.io.*; //Include libraries
 import java.util.*;
 
 public class MainDriverYahtzee
 {
 	public static void main(String[] args) throws IOException, InterruptedException
 	{
 		//DEFINE VARIABLES
 		ArrayList<Integer> dice=new ArrayList<Integer>(); //ArrayList for Dice
 		int[] reroll=new int[6]; //Reroll dice
 		
 		reroll[0]=2; //Sets all rerolls options to Reroll (allows first roll to occur)
 		reroll[1]=2;
 		reroll[2]=2;
 		reroll[3]=2;
 		reroll[4]=2;
 		reroll[5]=2;
 		
 		int dice1=0; //Creates dice
 		int dice2=0;
 		int dice3=0;
 		int dice4=0;
 		int dice5=0;
 		int mykey=0; //Pause key
 		 		
 		Scanner keyboard=new Scanner(System.in);
 	
 		for(int round=1;round<=13;round++)
 		{
 			for(int i=1;i<=3;i++) //Roll Dice Loop	
 			{
 				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); // Clear Screen Command
	 			if(reroll[0]==2) //Roll
 				{
 					dice1=roll();
 				}
	 			if(reroll[1]==2) //Roll
 				{
 					dice2=roll();
 				}
	 			if(reroll[2]==2) //Roll
 				{
 					dice3=roll();
 				}
	 			if(reroll[3]==2) //Roll
 				{
 					dice4=roll();
 				}
	 			if(reroll[4]==2) //Roll
 				{
 					dice5=roll();
 				}
	 			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 				System.out.println("ROUND: "+round+"                    ROLL: "+i);
				System.out.println("Dice 1: "+dice1);
	 			System.out.println("Dice 2: "+dice2);
 				System.out.println("Dice 3: "+dice3);
 				System.out.println("Dice 4: "+dice4);
 				System.out.println("Dice 5: "+dice5);
 				System.out.println("");
 			
 				if(i!=3) //Choose what to keep
 				{
 					System.out.println("DO YOU WANT TO KEEP DICE 1?"); //REROLL DICE 1?
					System.out.println("[INPUT ANSWER]");
					System.out.println("     1) Yes");
	 				System.out.println("     2) No");
 			
 					reroll[0]=keyboard.nextInt(); //If 1, Reroll
 					if((reroll[0]!=1)&&(reroll[0]!=2)) //Tests if Yes or No was given; defaults to no reroll
	 				{
 						reroll[0]=1;
 					}
	 				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////2
					System.out.println("DO YOU WANT TO KEEP DICE 2?"); //REROLL DICE 2?
	 				System.out.println("[INPUT ANSWER]");
 					System.out.println("     1) Yes");
 					System.out.println("     2) No");
 			
 					reroll[1]=keyboard.nextInt(); //If 1, Reroll
 					if((reroll[1]!=1)&&(reroll[1]!=2)) //Tests if Yes or No was given; defaults to no reroll
	 				{
 						reroll[1]=1;
 					} 		
 					////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////3
 					System.out.println("DO YOU WANT TO KEEP DICE 3?"); //REROLL DICE 3?
 					System.out.println("[INPUT ANSWER]");
 					System.out.println("     1) Yes");
 					System.out.println("     2) No");
 			
 					reroll[2]=keyboard.nextInt(); //If 1, Reroll
 					if((reroll[2]!=1)&&(reroll[2]!=2)) //Tests if Yes or No was given; defaults to no reroll
	 				{
 						reroll[2]=1;
 					}
 					////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////4
					System.out.println("DO YOU WANT TO KEEP DICE 4?"); //REROLL DICE 4?
					System.out.println("[INPUT ANSWER]");
					System.out.println("     1) Yes");
					System.out.println("     2) No");
 				
					reroll[3]=keyboard.nextInt(); //If 1, Reroll
					if((reroll[3]!=1)&&(reroll[3]!=2)) //Tests if Yes or No was given; defaults to no reroll
					{
						reroll[3]=1;
					}
					////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////5
					System.out.println("DO YOU WANT TO KEEP DICE 5?"); //REROLL DICE 5?
					System.out.println("[INPUT ANSWER]");
					System.out.println("     1) Yes");
					System.out.println("     2) No");
 				
					reroll[4]=keyboard.nextInt(); //If 1, Reroll
					if((reroll[4]!=1)&&(reroll[4]!=2)) //Tests if Yes or No was given; defaults to no reroll
					{
						reroll[4]=1;
					}
 				} //End Choose what to keep
 			} //Close Roll Dice Loop
 			dice.add(dice1);
 			dice.add(dice2);
	 		dice.add(dice3);
 			dice.add(dice4);
 			dice.add(dice5);
 		
 			Collections.sort(dice);
 			System.out.println(dice); 
 			mykey=(int)System.in.read(); //Pause
 			
 			///PASS TO PARTNER PROGRAM DUUUUUUUDE!!!
 			
		} //Thirteen Rounds of the Game
		
		//Final Score Stuff AND HOW DID I DO, BROOOOO!
			
 	} 	//Close main Method
 	
 	public static int roll()
 	{
 		Random generator = new Random(); //Random Number Block
		int random=0;
		
		random=generator.nextInt(6)+1; //Rolls dice (1-6)
		switch(random) //Decides which Ascii Art to Display based on Dice roll.
		{
			case 1:
				rollone();
				break;
			case 2:
				rolltwo();
				break;
			case 3:
				rollthree();
				break;
			case 4:
				rollfour();
				break;
			case 5:
				rollfive();
				break;
			case 6:
				rollsix();
				break;
			default:
				System.out.println("Welcome to the Far Lands of brokenness.");
				break;	
		} //Close ASCII switch
				
		System.out.println("");
		return(random); //Transfers random back as dice n.
 	} //Close Roll
 	
 	public static void rollsix()
	{
		System.out.println("  ________   " );
		System.out.println(" /_______/|   ");
		System.out.println(" | o   o ||   ");
		System.out.println(" | o   o ||   " );
		System.out.println(" | o   o |/   " );
		System.out.println("  =======     ");
	} //Die 6 Display
	
	public static void rollfive()
	{
		System.out.println("  ________    ");
		System.out.println(" /_______/|   " );
		System.out.println(" | o   o ||    ");
		System.out.println(" |   o   ||    " );
		System.out.println(" | o   o |/    ");
		System.out.println("  =======      ");
	} //Die 5 Display

	public static void rollfour()
	{
		System.out.println("  ________     " );
		System.out.println(" /_______/|     ");
		System.out.println(" | o   o ||     " );
		System.out.println(" |       ||      " );
		System.out.println(" | o   o |/     " );
		System.out.println("  =======       " );
	} //Die 4 Display
	
	public static void rollthree()
	{
		System.out.println("  _______       " );
		System.out.println(" |\\______\\    " );
		System.out.println(" || o   o |      " );
		System.out.println(" ||       |      " );
		System.out.println(" \\|   o   |    " );
		System.out.println("    =======       " );
	} //Die 3 Display
	
	public static void rolltwo()
	{
		System.out.println("  _______       ");
		System.out.println(" |\\______\\    " );
		System.out.println(" || o     |      " );
		System.out.println(" ||       |     " );
		System.out.println(" \\|     o |     ");
		System.out.println("    =======       ");
	} //Die 2 Display
	
	public static void rollone()
	{
		System.out.println("  _______        " );
		System.out.println(" |\\______\\     ");
		System.out.println(" ||       |      " );
		System.out.println(" ||   o   |        ");
		System.out.println(" \\|       |      " );
		System.out.println("    =======        " );
	} //Die 1 Display
 } //Close MainDriverYahtzee Class