package towerDefence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Game {
	
	public static final int BUDGET = 600;
    public static final int THREE = 3;

	private Random randomGenerator;
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	
	private int corridorLength = 0;
    private int budget;
	
	
	
	
	
	
	
	
	
	public Game(int corridorLengthIn) {
		this.corridorLength = corridorLengthIn;
		randomGenerator = new Random();
		budget = BUDGET;
		insertTowers();
	}
	


	public void advance() {
		
	}
	
	
	public void drawCorridor() {
		int twrs[] = new int[towers.size()];
		for (int i = 0; i < towers.size(); i++) {
			twrs[i] = towers.get(i).getPosition();
		}
		for (int i = 0; i < towers.size(); i++) {
			for (int j = i + 1; j < towers.size(); j++) {
				if (towers.get(i).getPosition() > towers.get(j).getPosition()) {
					Collections.swap(towers, i, j);
				}
			}
		}
		
		for(;;) {
			
			int len = this.corridorLength;
			System.out.println("\n");
			int flag = 0;
			for (int i = 0; i <= len; i++) {
				flag = 0;
				//int towers.get(j).getPosition());
				for (int j = 0; j < twrs.length; j++) {
					if (twrs[j] == i) {
						System.out.print(towers.get(j));
						flag = 1;
					}
				}
				if (i < len && flag == 0) {
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
				if (!enemies.isEmpty() && towers.get(i).willFire(Tower.getTimeStep()) && towers.get(i).getPosition() > enemies.get(0).getPosition()) {
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
	
	
	
	
	
	
	
	public void insertTowers() {
		int currentRandomNum = randomGenerator.nextInt(THREE);
		//Budget 600: slingshot = 200, catapult = 250, cannon = 400
		//Possible combinations: 0 is 3 slingshots, 1 is 1 catapult and one slingshot, 2 is 1 slingshot and 1 cannon
		switch(currentRandomNum) {
		case 0:
			insertSlingshotAt((corridorLength / 2) + (randomGenerator.nextInt(corridorLength / 2)));
            // This while loop checks if position is already taken by another tower
            while (!insertSlingshotAt(corridorLength / 2 + randomGenerator.nextInt(corridorLength / 2+ 1)));
            while (!insertSlingshotAt(corridorLength / 2 + randomGenerator.nextInt(corridorLength / 2+ 1)));
            break;
		case 1:
			insertSlingshotAt((corridorLength / 2) + (randomGenerator.nextInt(corridorLength / 2 + 1)));
            while(!insertCatapultAt((corridorLength / 2) + (randomGenerator.nextInt(corridorLength / 2 + 1))));
			break;
		default:
			insertCatapultAt((corridorLength / 2) + (randomGenerator.nextInt(corridorLength / 2 + 1)));
            while(!insertCatapultAt((corridorLength / 2) + (randomGenerator.nextInt(corridorLength / 2 + 1))));
            break;
		}
	}
	
	
	
	private boolean insertCatapultAt(int position) {
		// TODO Auto-generated method stub
		if(!checkIfTowerAt(position) && (position >= 1) &&  (position <= corridorLength)) {
			Tower newCatapult = new Catapult(position);
            System.out.println("POSITION  C                               "  + position);
			towers.add(newCatapult);
			budget -= newCatapult.getCost();
			return true;
		}
		return false;
	}



	public boolean insertSlingshotAt(int position) {
        // Check if the proposed position is available and within the proper limits
        if ((!checkIfTowerAt(position)) && (position >= 1) && (position <= corridorLength)) {
            Slingshot newSlingshot = new Slingshot(position);
            System.out.println("POSITION                                "  + position);
            towers.add(newSlingshot);   // Place Tower
            budget -= newSlingshot.getCost();   // Update budget
            return true;
        }
        else {
            return false;
        }
	}
	
	public boolean checkIfTowerAt(int positionIn) {
		Iterator<Tower> towerIterator = towers.iterator();
		while(towerIterator.hasNext()) {
			if(towerIterator.next().getPosition() == positionIn) {
				return true;
			}
		}
		return false;
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
