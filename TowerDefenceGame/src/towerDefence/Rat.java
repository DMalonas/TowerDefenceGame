package towerDefence;

public class Rat extends Enemy{

	public Rat() {
		super(0);
		System.out.println("Rat created");
	}
	
	@Override
    public String toString() { 
		 return String.format("R"); 
	} 
}
