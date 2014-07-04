//FVCproductions
//Program Name: Game_FCoronel.java
//Instructor: Ms. Katina Brown
//Date: February 13, 2014
//Description: Chapter 3

public class Game_FCoronel 
{

// declaring private variables

	private String playerName;
	private int expLevel;
	private double score;

// accessor method for player name		
	public String getPlayerName() 
	{
		return playerName;
	}

// mutator method for player name

	public void setPlayerName(String n) 
	{
		playerName = n;
	}
	
// accessor method for exp level
		
	public int getExpLevel() 
	{
		return expLevel;
	}

// mutator method for exp level

	public void setExpLevel(int e) 
	{
		expLevel = e;
	}	

// accessor method for calc score

	public double calcScore() 
	{
		score = score*5 - 2;
		return score;
	}

// mutator method for calc score

	public void setScore(double sc)
	{
		score = sc;
	}

}