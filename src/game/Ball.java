package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public int x = 256, y = 256, sizex = 16, sizey = 16, speed = 5, m = 0;
	public double dx = 0, dy = 0;
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x-sizex/2, y-sizey/2, sizex, sizey);
	}
	
	public void update() {
		dx = Math.sin(m) * speed;
		dy = Math.cos(m) * speed;
		x += dx;
		y += dy;

		}
	
	public boolean collides(Player player) {
		if (((player.y + player.sizey/2 >= y + sizey) && (player.y- player.sizey/2 <= y-sizey/2)) && (player.x <= x)) {
			return true;
		}
		return false;
		
	}
}
