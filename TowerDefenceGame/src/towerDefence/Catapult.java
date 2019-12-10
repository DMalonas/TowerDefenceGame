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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
}
