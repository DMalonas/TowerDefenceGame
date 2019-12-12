package towerDefence;

public class Buffalo extends Enemy{
	private int health;
	
	public Buffalo() {
		super(0);
		health = 6;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public void advance() {
		this.setPositionB();
	}
	
	@Override
	public void hit(Tower t) {
		if (t.getName() == "C") {
			health -= 5;
		} else if (t.getName() == "S") {
			health -= 1;
		} else if (t.getName() == "N") {
			health -= 5;
		}
	}
	
	@Override
    public String toString() { 
		 return String.format("B"); 
	} 
}
