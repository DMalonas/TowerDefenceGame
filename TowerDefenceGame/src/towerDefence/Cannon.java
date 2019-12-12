package towerDefence;

public class Cannon extends Tower{

	private String name;
	
	public Cannon(int positionIn) {
		super(positionIn, "N");

		// TODO Auto-generated constructor stub
	}


	@Override
	public int getDamage() {
		return 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	boolean willFire(int timeStep) {

		if (timeStep % 2 == 1 && timeStep != 0) {
			
			return true;
		}
		return false;
	}

	@Override
    public String toString() { 
		 return String.format("N"); 
	}
}