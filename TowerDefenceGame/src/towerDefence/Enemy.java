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
	
	void hit(Tower t) {
	}
	
	public void setPositionRat() {
		this.position += 2;
	}

	public void setPositionEl() {
		this.position += 1;
	}
	
	
	public void setPositionB() {
		this.position += 1;
	}
	
	public void advance() {}
	
	@Override
    public String toString() { 
		 return String.format("Enemy"); 
	}
}
