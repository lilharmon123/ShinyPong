
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
import game.Player;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

		private static final long serialVersionUID = 1L;
		private int S_WIDTH = 512;
		private int S_HEIGHT = 512;
		
		private Player player;
		private Ball ball;
		private int time = 0;
		private Timer timer;
		private Random random = new Random();
		private double i = 0;
		
		public GamePanel() {
			addKeyListener(this);
			setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
			
			player = new Player();
			ball = new Ball();
			//ball.m = random.nextInt(10);
			ball.m = 1;
			
			
			
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
			player.update();
			ball.update();
			
			
			if(ball.collides(player))
			{
				System.out.println("true");
				//ball.dx = ball.dx*-1;
				ball.dx = 0;
				ball.dy = 0;
				System.out.println(ball.dx);
			}
				
				
			//else
				//System.out.println("false");
				
				
				
			repaint();
			
		}


		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


	
}
	