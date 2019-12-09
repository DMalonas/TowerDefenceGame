package towerDefence;

import java.util.ArrayList;

public class Game {
	private ArrayList<Enemy> enemies;
	private ArrayList<Tower> towers;
	
	private int corridorLength = 0;
	
	public Game(int corridorLengthIn) {
		this.corridorLength = corridorLengthIn; 
	}
	
	public void advance() {
		
	}
	
	public int getCorridorLength() {
		return corridorLength;
	}

	public void setCorridorLength(int corridorLength) {
		this.corridorLength = corridorLength;
	}
	
	@Override
    public String toString() { 
		 return String.format("Game"); 
	} 

}
