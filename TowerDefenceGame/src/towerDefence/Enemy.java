package towerDefence;

public class Enemy {
	
	int getHealth() {
		return 1;
	}
	
	int getPosition() {
		return 1;
	}
	
	void hitTower(Tower t) {
		
	}
	
	void advance() {
		
	}
	
	@Override
    public String toString() { 
		 return String.format("Enemy"); 
	}
}
