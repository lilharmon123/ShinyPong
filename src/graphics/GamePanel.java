
package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.Ball;
import game.Opponent;
import game.Player;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

		private static final long serialVersionUID = 1L;
		private int S_WIDTH = 512;
		private int S_HEIGHT = 512;
		
		private Player player;
		private Ball ball;
		private Opponent opponent;
		private int time = 0;
		private int difficulty = 3;
		private int pscore = 0;
		private int oscore = 0;
		private Timer timer;
		private Random random = new Random();
		private double i = 0;
		
		public GamePanel() {
			addKeyListener(this);
			setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
			
			player = new Player();
			ball = new Ball();
			opponent = new Opponent();
			
			
			
			
			
			timer = new Timer(50, this);
			timer.start();


			setFocusable(true);
			requestFocus();
			
			repaint();
		}
		
		
		public void paintComponent(Graphics g) {
			// clear screen
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
			
			player.draw(g);
			ball.draw(g);
			opponent.draw(g);
		}
	
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				player.movingDown = true;
				player.movingUp = false;
				break;
			case KeyEvent.VK_DOWN:
				player.movingDown = false;
				player.movingUp = true;
				break;
		
			}
		}
		
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				player.movingDown = false;
				break;
			case KeyEvent.VK_DOWN:
				player.movingUp = false;
				break;
			}
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			time++;
			
			
			if(pscore == 2 || oscore == 2) {
				System.exit(0);
			}
			
			if(ball.collidesp(player))
			{
				System.out.println("true");
				//i = ball.dx;
				//ball.dx = ball.dy;
				//ball.dy = i;
				
				ball.dx = ball.dx * -1;
				
				System.out.println(ball.dx);
				System.out.println(ball.x);
				
			}
			
			if(ball.collideso(opponent))
			{
				//System.out.println("true");
				//i = ball.dx;
				//ball.dx = ball.dy;
				//ball.dy = i;
				
				ball.dx = ball.dx * -1;
				
				//System.out.println(ball.dx);
				//System.out.println(ball.x);
			}
			
			if(ball.collidesw(S_HEIGHT)) {
				ball.dy = ball.dy * -1;
				//System.out.println("yeet");
			}
			
			if(ball.collideseo()) {
				ball.start();
				pscore++;
				System.out.println("player scored");
			}
			if(ball.collidesep()) {
				ball.start();
				oscore++;
				System.out.println("opponent scored");
			}
				
				
		
			if(random.nextInt(difficulty)==1){
			if(opponent.y >= ball.y) {
				opponent.movingDown = true;
				opponent.movingUp = false;
			}
			if(opponent.y <= ball.y) {
				opponent.movingDown = false;
				opponent.movingUp = true;
			}
			}
			
			
			
			
			
			player.update();
			ball.update();
			opponent.update();
			//System.out.println(ball.y);
			
			
			
			
			
			repaint();
			
		}
		



		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


	
}
	