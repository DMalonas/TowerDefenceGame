package towerDefence;

public class Slingshot extends Tower{

	private String name = "S";
	
	public Slingshot(int positionIn) {
		super(positionIn, "S");
		System.out.print("slingshot created");
		// TODO Auto-generated constructor stub
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
}
