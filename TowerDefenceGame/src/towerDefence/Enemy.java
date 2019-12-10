package towerDefence;

public class Enemy{
	private int position = 0;
	
	public Enemy(int positionIn) {
		this.position = positionIn;
	}
	int getHealth() {
		return 1;
	}
	
	int getPosition() {
		return this.position;
	}
	
	void hitTower(Tower t) {
		
	}
	
	public void setPositionRat() {
		this.position++;
	}
	
	void advance() {
		this.position+=10;
	}
	
	@Override
    public String toString() { 
		 return String.format("Enemy"); 
	}
}
