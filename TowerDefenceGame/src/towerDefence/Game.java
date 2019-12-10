package towerDefence;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
		for(;;) {
			int len = this.corridorLength;
			System.out.println("\n");
	
			for (int i = 0; i < len; i++) {
				System.out.print("_");
			}
			System.out.println("\n");
			for (int i = 0; i < enemies.size(); i++) {
				int pos = enemies.get(i).getPosition();
				//System.out.println(pos);

				for (int j = 0; j < pos; j++) {
					
					System.out.print(" ");
				}
				System.out.print(enemies.get(i) + " ");
				enemies.get(i).advance();
				if (enemies.get(i).getPosition() == len) {
					System.out.println();
					for (int k = 0; k < len; k++) {
						System.out.print("_");
					}
					System.out.print("|");
					System.out.println("\nGame over");
					return;
				}
				//System.out.println(enemies.get(i).getPosition());
			}
			System.out.println();
			for (int i = 0; i < len; i++) {
				System.out.print("_");
			}
			System.out.print("|");
			System.out.println("\n\n\n\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
