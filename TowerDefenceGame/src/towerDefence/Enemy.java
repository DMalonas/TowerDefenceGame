package towerDefence;

public class Enemy {
	private int position = 0;
	
	public Enemy(int positionIn) {
		this.position = positionIn;
	}
	int getHealth() {
		return 1;
	}
	
	int getPosition() {
		return 1;
	}
	
	void hitTower(Tower t) {
		
	}
	
	void advance() {
		position++;
	}
	
	@Override
    public String toString() { 
		 return String.format("Enemy"); 
	}
}
