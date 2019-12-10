package towerDefence;

public class Tower {
	private int position;
	private String name;
	private static int timeStep = 0;

	public Tower(int positionIn, String nameIn) {
		this.position = positionIn;
		this.setName(nameIn);
	}
	int getDamage() {
		return 1;
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
	
	
	public static int getTimeStep() {
		return timeStep;
	}
	public static void setTimeStep() {
		timeStep++;
	}
	
	
	@Override
    public String toString() { 
		 return String.format("Tower");
	}



}
