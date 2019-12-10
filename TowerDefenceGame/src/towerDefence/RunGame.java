/**
 * 
 */
package towerDefence;

/**
 * 
 *  * The RungGame class is the application class 
 * of the project - contains the main method. 
 * What happens here is that a Game object is
 * instantiated and its advance() method is 
 * called repeatedly using a while loop that
 * has as a condition the boolean return value
 * of the Game method gameEnded(). This program
 * is a basic 2-mode simple game. It is moddeled
 * using enemies and towers. The enemies are 
 * generated on the left side of an array and 
 * if any of them reaches the end of the array
 * then the game ends. The towers have firing
 * power and frequency and the enemies have 
 * forward moving speed, coins and health. 
 * In the simple mode where the player only has
 * to give the linelength as args[0] the game 
 * is evolves in an automatic manner. Random types
 * of towers are generated in random positions and
 * then enemies try to reach the end of the array-corridor
 * and the program does not stop till an enemy succeeds. 
 * In the extended mode that is accessed by running the program
 * providing line length as args[1] and "-e" (e for extended) for
 * args[2], the player gets to use a menu that allows them to buy
 * towers and place them where they want. And based on the itterations
 * (timesteps) of the game and the length of the array (corridor) that
 * the Enemy objects need to parse through, and the budget, the normal narrative of the
 * game is paused and the user is presented with a menu that informs
 * them about their budget (which increases as Enemy objects are killed)
 * and their options of going to the Tower Purchase menu for buying towers
 * or continuing playing without buying more Tower objects, or exiting the game entirely
 * The extended mode very vaguely resembles an actual game due to this interactions availability.
 * 
 * @author Dimitrios
 *
 */
public class RunGame {

	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game(40);
		
		Enemy e1 = new Rat();
		Enemy e2 = new Rat();
		Enemy e3 = new Elephant();
		Enemy e4 = new Elephant();
		Enemy e5 = new Elephant();
		Enemy e6 = new Elephant();
		Enemy e11 = new Elephant();
		Enemy e12 = new Elephant();		
		game.setEnemies(e1);
		game.setEnemies(e2);
		game.setEnemies(e3);
		game.setEnemies(e4);
		game.setEnemies(e5);
		game.setEnemies(e6);

		game.setEnemies(e11);
		game.setEnemies(e12);
		Tower slingshot1 = new Slingshot(30);
		Tower catapult1 = new Catapult(39);
		game.setTowers(slingshot1);
		game.setTowers(catapult1);
		
		//System.out.println(game.getEnemies());
		game.drawCorridor();
		
	}

}
