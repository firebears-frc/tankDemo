package tankdemo;

import processing.core.PApplet;

/**
 * Sample Processing Applet that just drives the tank around with the WASD keys.
 * This class represents the arena in which the game is played.  Also, it
 * represents the window that pops up.  It can interface with the keyboard and
 * the mouse.
 */
public class TankDemo extends PApplet {

	Tank tank;
	int state = 0;
	
	public void setup() {
		size(640,480);
		tank = new Tank(this);
	}

	public void draw() {
		background(128, 128, 128);
        float timeDiff = 1.0f / frameRate;
        tank.run(timeDiff);

		if (keyPressed) {
			state = 0;
			if (key=='w') {
				tank.setSpeed(40);
			} else if (key == 's') {
				tank.setSpeed(-40);
			} else if (key == 'a') {
				tank.turn(-30);
			} else if (key == 'd') {
				tank.turn(30);
			} 
		} else if (state == 1) {
			// Do something different in state 1
		} else {
			tank.setSpeed(0);
			tank.turn(0);
			state = 0;
		}
	}
}
