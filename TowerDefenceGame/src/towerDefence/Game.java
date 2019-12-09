package towerDefence;

import java.util.ArrayList;

public class Game {
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers;
	
	private int corridorLength = 0;
	
	public Game(int corridorLengthIn) {
		this.corridorLength = corridorLengthIn;
		System.out.println("Here");
	}
	


	public void advance() {
		
	}
	
	
	public void drawCorridor() {
		int len = this.corridorLength;
		System.out.println("\n");

		for (int i = 0; i < len; i++) {
			System.out.print("__ ");
		}
		System.out.println("\n");
		for (int i = 0; i < enemies.size(); i++) {
			int pos = enemies.get(i).getPosition();
			System.out.print(enemies.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < len; i++) {
			System.out.print("__ ");
		}

	}
	public int getCorridorLength() {
		return corridorLength;
	}

	public void setCorridorLength(int corridorLength) {
		this.corridorLength = corridorLength;
	}
	
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemy enemyIn) {
		enemies.add(enemyIn);
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}
	
	@Override
    public String toString() { 
		 return String.format("Game"); 
	}



	

}
