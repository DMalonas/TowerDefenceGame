package towerDefence;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Game {
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	
	private int corridorLength = 0;
	
	public Game(int corridorLengthIn) {
		this.corridorLength = corridorLengthIn;
	}
	


	public void advance() {
		
	}
	
	
	public void drawCorridor() {
		int twrs[] = new int[towers.size()];
		for (int i = 0; i < towers.size(); i++) {
			twrs[i] = towers.get(i).getPosition();
		}
		for(;;) {
			
			int len = this.corridorLength;
			System.out.println("\n");
			for (int i = 0; i < len; i++) {

				//	int towers.get(j).getPosition());
					for (int j = 0; j < twrs.length; j++) {
						if (twrs[j] == i) {
							System.out.print(towers.get(j));
							i++;
						}
					}
					if (i < len) {
						System.out.print("_");					
					}
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
				System.out.println();
				//System.out.println(enemies.get(i).getPosition());
			}
			System.out.println();
			for (int i = 0; i < len; i++) {
				System.out.print("_");
			}
			System.out.print("|");
			System.out.println("\n\n\n\n");
			if (enemies.isEmpty()) {
				System.out.println("All enemies were defeated");
				return;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 0; i < twrs.length; i++) {
				if (towers.get(i).willFire(Tower.getTimeStep()) && towers.get(i).getPosition() > enemies.get(0).getPosition()) {
					for (int j = 0; j < 1; j++) {
						enemies.get(j).hitTower(towers.get(i));
						if (enemies.get(j).getHealth() <= 0) {
							enemies.remove(j);
						}
					}
				}
			}
			Tower.setTimeStep();
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

	public void setTowers(Tower towerIn) {
		this.towers.add(towerIn);
	}
	
	@Override
    public String toString() { 
		 return String.format("Game"); 
	}



	

}
