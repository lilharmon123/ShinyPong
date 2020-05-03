package game;

import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

public class Ball {
	private Random random = new Random();

	public int x = 256, y = 256, sizex = 16, sizey = 16;
	public double m = 3 *random.nextDouble(), speed = 5, dx = Math.sin(m), dy = Math.cos(m);

	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x-sizex/2, y-sizey/2, sizex, sizey);
	}
	
	public void update() {
		
		x += dx * speed;
		y += dy * speed;
		speed += .01;
		//System.out.println(speed);
		

		}
	
	public void start() {
		x = 256;
		y = 256;
		speed = 5;
		m = 2;
		dx = Math.sin(m);
		dy = Math.cos(m);
	}
	
	public boolean collidesp(Player player) {
		if (((player.y + player.sizey/2 >= y + sizey) && (player.y- player.sizey/2 <= y-sizey/2)) && (player.x - player.sizex/2 <= x + sizex/2)&&(player.x>= x)) {
			
			return true;
		}
		return false;
	}
	
	public boolean collidesw(int height) {
		if (20 >= (y + sizey) || 500 <= (y - sizey)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean collideso(Opponent opponent) {
if (((opponent.y + opponent.sizey/2 >= y + sizey) && (opponent.y- opponent.sizey/2 <= y-sizey/2)) && ((opponent.x + opponent.sizex/2 >= x - sizex/2)&&(opponent.x<= x))) {
			
			return true;
		}
		return false;
	}
	
	public boolean collideseo() {
		if (30 >= (x+ sizex)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean collidesep() {
		if (520 <= (x+ sizex)) {
			return true;
		}
		else {
			return false;
		}
	}
}
