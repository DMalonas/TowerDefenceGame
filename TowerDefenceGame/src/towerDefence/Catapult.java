package towerDefence;

public class Catapult extends Tower{

	private String name;
	
	public Catapult(int positionIn) {
		super(positionIn, "C");
		System.out.print("Catapult created");

		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() { 
		 return String.format("C"); 
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
	

	public static int getTimeStep() {
		return Tower.getTimeStep();
	}
	
	
	public static void setTimeStepC() {
		Tower.setTimeStep();
	}
	
	
	
}
