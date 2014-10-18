tankDemo
========

Processing demo:  Simple tank driving around the screen.

This is not really a game, but rather a game mechanic that might
become part of a game.    

Programmers rarely get to write everything from scratch.  Instead
we typically start with existing code or libraries and build from
that.  The objective of this demo is that you read and understand
the existing code and then make it do other things.

## Some things to try:
* Appearance
  * Modify the 'run' method in the 'Tank' class so the tank looks different.
* Driving
  * The current code drives the tank with the WASD keys on the keyboard.  Modify 'TankDemo' so it drives with the mouse, using Processing's 'mouseX' and 'mouseY' variables.
  * Add a second tank on the screen that drive with the IJKL keys.
* Obstacles
  * Change 'Tank' so the tank won't drive off the screen.  It should stop before any of its edges. 
  * Create a new 'Obstacle' class.  The 'Tank' must stop when it hits anything.  Make a maze.
* Shooting
  * Create a new 'Bullet' class, and cause the space bar to shoot bullets from the tank.  For now, only allow one 'Bullet' on the screen at once.  Bullets should disappear if they fly more than 300 pixels.
  