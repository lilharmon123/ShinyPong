package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author jacob
 *
 */
public class Player {
	public int x = 450, y = 256, sizex = 16, sizey = 100, speed = 12;
	public boolean movingDown = false, movingUp = false;
	
	public void update() {
		if(movingDown) {
			y -= speed;
		}
		if(movingUp) {
			y += speed;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x-sizex/2, y-sizey/2, sizex, sizey);
	}
	
	/*public boolean collides(EnemyBullet b) {
		if(Math.sqrt(Math.pow(x-b.x, 2)+ Math.pow(y-b.y, 2)) <= (size+b.size)/2) {
			return true;
		}
		return false;
	}
  */
}
