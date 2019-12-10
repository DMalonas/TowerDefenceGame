package towerDefence;

public class Elephant extends Enemy{

	private int health;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Elephant() {
		super(0);
		health = 10;
	}

	@Override
	public void hitTower(Tower t) {
		if (t.getName() == "C") {
			health -= 5;
		} else if (t.getName() == "S") {
			health -= 1;
		}
	}
	
	
	@Override
	public void advance() {
		this.setPositionEl();
	}
	
	@Override
    public String toString() { 
		return String.format("E");
	}
}
