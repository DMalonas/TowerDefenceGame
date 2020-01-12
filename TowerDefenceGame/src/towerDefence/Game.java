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
    public static final double PROB_88 = 0.88;
    public static final double PROB_66 = 0.66;
    public static final double PROB_33 = 0.33;
    public static final int ONE_HUNDRED = 100;
    
	private Random randomGenerator;
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	
	private float probabilityOfNewEnemyPerTimeStep;
	private int corridorLength;
    private int budget;
    private int currentTimeStep;
    private Enemy[] corridor;   //Array that stores the information of what kind of Enemy, if any, is in every position
	private boolean gameEnded;

	
	
	
	
	
	
	
	
	public Game(int corridorLengthIn) {
		this.corridorLength = corridorLengthIn;
		randomGenerator = new Random();
		probabilityOfNewEnemyPerTimeStep = (float) PROB_88;
		budget = BUDGET;
		currentTimeStep = 0;
		corridor = new Enemy[corridorLength + 1];
		gameEnded = false;
		emptyCorridor();
		insertTowers();
	}



	private void emptyCorridor() {
		int len = corridor.length;
		for (int i = 0; i < len; i++) {
			corridor[i] = null;
		}
	}




	
	
	public void advance() {
		this.currentTimeStep++;
	
		//Enemies advance with lambda
		enemies.removeIf(enemy -> enemy.getHealth() <= 0);
		enemies.forEach(enemy -> {
			enemy.advance();
	        if (enemy.getPosition() >= corridorLength) {
	            System.out.println("Game ended");
	            System.exit(0);
	        }
			corridor[enemy.getPosition()] = enemy;
			
		});
		//Enemies advance with Iterator
//		Iterator<Enemy> enemyIterator = enemies.iterator();
//		Enemy currentEnemy;
//		while(enemyIterator.hasNext()) {
//			currentEnemy = enemyIterator.next();
//			if (currentEnemy.getHealth() <= 0) {
//				enemyIterator.remove();
//			} else {
//				currentEnemy.advance();
//		        if (currentEnemy.getPosition() >= corridorLength) {
//		            System.out.println("Game ended");
//		            System.exit(0);
//		        }
//				corridor[currentEnemy.getPosition()] = currentEnemy;
//			}
//		}
		
		//Towers shoot
		Iterator<Tower> towerIterator = towers.iterator();
		Tower currentTower;
		int towerPosition = 0;
		int indexPosition = 0;
		boolean currentTowerFired;
		while(towerIterator.hasNext()) {
			currentTower = towerIterator.next();
			//Check if it is supposed to fire
			//Prepare for finding which enemy can/will shoot
			if(currentTower.willFire(this.currentTimeStep)) {
				towerPosition = currentTower.getPosition();
				indexPosition = towerPosition;
				currentTowerFired = false;
				//While it has not found nothing available to hit, it keeps on looking until nothing is found at the available positions
				while((indexPosition > 0) && (!currentTowerFired)) {
					//If enemy is found hit it
					if(corridor[indexPosition] != null) {
						corridor[indexPosition].hit(currentTower);
						currentTowerFired = true;
					}
					indexPosition--;
				}
			}
		}


        System.out.println("\n" + this + "\n");

        if(corridor[corridorLength] != null) {
        	gameEnded = true;
        }
        // Clear corridor array for the next step to remake it from scratch with the new positions
        emptyCorridor();
		insertEnemyWithProbability(probabilityOfNewEnemyPerTimeStep);
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void insertEnemyWithProbability(float probability) {
		int getRandom = randomGenerator.nextInt(ONE_HUNDRED);
		if (getRandom < PROB_33 * probability * ONE_HUNDRED) {
			insertRat();
		} else if (getRandom < PROB_66 * probability * ONE_HUNDRED) {
			insertBuffalo();
		} else if (getRandom < probability * ONE_HUNDRED) {
			insertElephant();
		} else {
			insertElephant();
		}
	}
	
	public void insertRat() {
		Enemy newRat = new Rat();
		enemies.add(newRat);
	}
	public void insertElephant() {
		Enemy newElephant = new Elephant();
		enemies.add(newElephant);
	}
	public void insertBuffalo() {
		Enemy newBuffalo = new Buffalo();
		enemies.add(newBuffalo);
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
            while(!insertCannonAt((corridorLength / 2) + (randomGenerator.nextInt(corridorLength / 2 + 1))));
            break;
		}
	}
	
	
	private boolean insertCannonAt(int position) {
		if ((!checkIfTowerAt(position)) && (position >= 1) && (position <= corridorLength)) {
			Tower newCannon = new Cannon(position);
			System.out.println("POSITION N                                " + position);
			towers.add(newCannon);
			budget -= newCannon.getCost();
			return true;
		}
		return false;
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
	
	public boolean gameEnded() {
		return this.gameEnded;
	}
	
	@Override
    public String toString() {

		// Prepare string for Towers
        //we need two extra spaces: one for the zeroth element that we do not use, and one for the newline character as the last character of the char[]
        char[] stateTowers = new char[this.corridorLength + 2];
        for (int i = 0; i < (this.corridorLength + 1); i++) {
            stateTowers[i] = ' ';
        }
        Iterator<Tower> towerIterator = towers.iterator();
        Tower currentTower;
        while (towerIterator.hasNext()) {
            currentTower = towerIterator.next();
            if (currentTower instanceof Slingshot) {
                stateTowers[currentTower.getPosition()] = 'S';  // S: Slingshot
            }
            else if (currentTower instanceof Catapult) {
                stateTowers[currentTower.getPosition()] = 'C';  // C: Catapult
            }
            else {
                stateTowers[currentTower.getPosition()] = 'N';  // N: Cannon
            }
        }
        stateTowers[corridorLength + 1] = '\n';
		
		
		String stateEnemies = " ";
		for (int i = 0; i < corridorLength; i++) {
			if (corridor[i] == null)  {
				stateEnemies += ".";
			} else if (corridor[i] instanceof Rat) {
				stateEnemies += "r";
			} else if (corridor[i] instanceof Buffalo) {
				stateEnemies += "B";
			} else {
				stateEnemies += "E";
			}
		}
		//return String.format(stateEnemies);
		return "Current timestep: " + currentTimeStep + "\n" + String.valueOf(stateTowers) + stateEnemies + "\n\n";
	}



	

}
