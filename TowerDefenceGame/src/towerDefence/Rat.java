package towerDefence;

public class Rat extends Enemy{
	private int health;
	
	public Rat() {
		super(0);
		health = 1;
		System.out.println("Rat created");
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public void advance() {
		this.setPositionRat();
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
    public String toString() { 
		 return String.format("R"); 
	} 
}
