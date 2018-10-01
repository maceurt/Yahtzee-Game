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
 		
 		int i=1;
 		 		
 		Scanner keyboard=new Scanner(System.in); //New Scanner
		
 		for(int round=1;round<=13;round++) //Loop for Thirteen Rounds of Game
 		{ 			
			do //Roll Dice Loop
 			{	 			
	 			System.out.println("PRESS ENTER TO SHOOT THE DICE"); //Roll the Dice when wanted.
	 			mykey=(int)System.in.read(); //Pause
	 			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); // Clear Screen Command
	 		
	 			
	 			if(reroll[0]==2) //Roll dice 1 if set to reroll
 				{
 					dice1=roll();
 				}
	 			if(reroll[1]==2) //Roll dice 2 if set to reroll
 				{
 					dice2=roll();
 				}
	 			if(reroll[2]==2) //Roll dice 3 if set to reroll
 				{
 					dice3=roll();
 				}
	 			if(reroll[3]==2) //Roll dice 4 if set to reroll
 				{
 					dice4=roll();
 				}
	 			if(reroll[4]==2) //Roll dice 5 if set to reroll
 				{
 					dice5=roll();
 				}

 				System.out.println("ROUND: "+round+"                    ROLL: "+i); //Display Round and Roll Number, Numerical Dice instead of ASCII Art
				System.out.println("Dice 1: "+dice1);
	 			System.out.println("Dice 2: "+dice2);
 				System.out.println("Dice 3: "+dice3);
 				System.out.println("Dice 4: "+dice4);
 				System.out.println("Dice 5: "+dice5);
 				System.out.println("");
 			
 				if(i!=3) //Choose which dice to keep or reroll (will not work after third roll)
 				{
 					System.out.println("DO YOU WANT TO KEEP DICE 1?"); //Reroll dice 1?
					System.out.println("[INPUT ANSWER]");
					System.out.println("     1) Yes");
	 				System.out.println("     2) No");
 					reroll[0]=keyboard.nextInt(); //Input Roll or Keep
 					if((reroll[0]!=1)&&(reroll[0]!=2)) //Defaults to keep if invalid option given
	 				{
 						reroll[0]=1;
 					}
 					
					System.out.println("DO YOU WANT TO KEEP DICE 2?"); //Reroll dice 2?
	 				System.out.println("[INPUT ANSWER]");
 					System.out.println("     1) Yes");
 					System.out.println("     2) No");
 					reroll[1]=keyboard.nextInt(); //Input option
 					if((reroll[1]!=1)&&(reroll[1]!=2)) //Prevents invalid option
	 				{
 						reroll[1]=1;
 					} 		

 					System.out.println("DO YOU WANT TO KEEP DICE 3?"); //Reroll dice 3?
 					System.out.println("[INPUT ANSWER]");
 					System.out.println("     1) Yes");
 					System.out.println("     2) No");
 					reroll[2]=keyboard.nextInt(); //Input
 					if((reroll[2]!=1)&&(reroll[2]!=2)) //Invalid option test
	 				{
 						reroll[2]=1;
 					}

					System.out.println("DO YOU WANT TO KEEP DICE 4?"); //Reroll dice 4?
					System.out.println("[INPUT ANSWER]");
					System.out.println("     1) Yes");
					System.out.println("     2) No");
					reroll[3]=keyboard.nextInt(); //Input
					if((reroll[3]!=1)&&(reroll[3]!=2)) //Invalid option
					{
						reroll[3]=1;
					}

					System.out.println("DO YOU WANT TO KEEP DICE 5?"); //Reroll dice 5?
					System.out.println("[INPUT ANSWER]");
					System.out.println("     1) Yes");
					System.out.println("     2) No");
					reroll[4]=keyboard.nextInt(); //Input
					if((reroll[4]!=1)&&(reroll[4]!=2)) //Invalid?
					{
						reroll[4]=1;
					}
 				} //End Choose what to keep
 				i=i+1; //Next Round
 				
 				if((reroll[0]==1)&&(reroll[1]==1)&&(reroll[2]==1)&&(reroll[3]==1)&&(reroll[4]==1)) //Stops rerolling if all dice are to be kept
 				{
 					i=4; //Breaks loop
 				}			
 			}while(i<=3); //Stop rolling dice for that round after three rolls
 			
 			dice.add(dice1); //Add dice values to the Arraylist
 			dice.add(dice2);
	 		dice.add(dice3);
 			dice.add(dice4);
 			dice.add(dice5);
 		
 			Collections.sort(dice); //Sort/Pertify ArrayList for Passing
 			System.out.println(dice); //Display ArrayList
			
 			//Pass to Card Class
 		
 		 	dice.clear(); //Reset dice
 		 	reroll[0]=2; //Enable Reroll
 		 	reroll[1]=2;
 		 	reroll[2]=2;
 		 	reroll[3]=2;
 		 	reroll[4]=2;
 		 	reroll[5]=2;
 		 	i=1; //Reset roll set
		} //Thirteen Rounds of the Game
		
		//Final Score Calculations
			
 	} 	//Close main Method
 	
 	public static int roll() //Dice rolls
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
			default: //If the six sided dice rolls a seven
				System.out.println("Well I told him once or twice,"); //Easter Egg to In the Jailhouse Now (Soggy Bottom Boys)
				System.out.println("\"Stop playing cards and a-shooting dice.\"");
				System.out.println("He's in the jailhouse now.");
				System.out.println("How did you roll a seven?");
				
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