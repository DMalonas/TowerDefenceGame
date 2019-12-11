package towerDefence;

public class Slingshot extends Tower{

	private String name = "S";
	public static final int SLING_COST = 200;

	public Slingshot(int positionIn) {
		super(positionIn, "S");
		cost = SLING_COST;
		System.out.print("slingshot created");
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int getDamage() {
		return 1;
	}
	
	@Override
    public String toString() {
		 return String.format("S");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	boolean willFire(int timeStep) {
		if (timeStep != 0) {
			return true;
		}
		return  false;
	}
}
