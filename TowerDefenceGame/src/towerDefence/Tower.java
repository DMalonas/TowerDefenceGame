package towerDefence;

public class Tower {
	private int position;
	private String name;
    protected int cost;


	public Tower(int positionIn, String nameIn) {
		this.position = positionIn;
		this.setName(nameIn);
	}
	int getDamage() {
		return 1;
	}
	
    public int getCost() {
        return this.cost;
    }
    
	int getPosition() {
		return this.position;
	}
	
	boolean willFire(int timeStep) {
		return true;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
    public String toString() { 
		 return String.format("Tower");
	}



}
