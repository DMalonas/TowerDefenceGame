package towerDefence;

public class Catapult extends Tower{

	private String name;
	
	public Catapult(int positionIn) {
		super(positionIn, "C");
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

		if (timeStep % 3 == 0 && timeStep != 0) {
			
			return true;
		}
		return false;
	}

	@Override
    public String toString() { 
		 return String.format("C"); 
	}
}