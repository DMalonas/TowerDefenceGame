package towerDefence;

public class Tower {

	int getDamage() {
		return 1;
	}
	
	int getPosition() {
		return 1;
	}
	
	boolean willFire(int timeStep) {
		return true;
	}
	
	
	@Override
    public String toString() { 
		 return String.format("Tower");
	}

}
