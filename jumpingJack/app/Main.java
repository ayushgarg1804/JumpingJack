package jumpingJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;


	public class Main {

		static JFrame frame = new JFrame();		
	public static void main (String [] args) throws InterruptedException{
		
		frame.setSize(Game.WIDTH, Game.HEIGHT);					
		frame.setVisible(true);									
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);						
		
		runnit();	//begins running the method below
		
	}

	public static void runnit() throws InterruptedException{
		
		final Menu menu = new Menu();							//the menu used in each instance
		final Game game = new Game();							//the game used in each instance
		
		
		Timer animationTimer = new Timer(20, new ActionListener(){		//animation timer for the game, repaints the jumper, walls, and background every 20 milliseconds
			  public void actionPerformed(ActionEvent event){
				 game.repaint();
				 game.move();
			 };
		});
		
		frame.add(menu);							//adds the menu (Step 1)
		menu.setVisible(true);						
		frame.revalidate();							//makes sure the menu is displayed (Step 1.5)
		frame.repaint();
		
		while (menu.startGame == false){			//waits until the mouse is clicked in the Menu
			Thread.sleep(10);
		}
		
				
		frame.remove(menu);							//Removes menu when mouse is clicked(Step 2)
		frame.add(game);							//adds the game in its place (Step 3)
		game.setVisible(true);						//makes sure the game is displayed (Step 3.5)
		frame.revalidate();

		animationTimer.start();						//begins animation timer, and the game begins
		
	
}

}
