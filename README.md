tankDemo
========

Processing demo:  Simple tank driving around the screen.

This is not really a game, but rather a game mechanic that might
become part of a game.    

Programmers rarely get to write everything from scratch.   Instead
we typically start with existing code or  libraries and build from
that.   The objective of this demo is that you read and understand
the existing code and then make it do other things.  The important
classes are 'Tank' and 'TankDemo'.  Don't worry too much about the
others at first.

## Some things to try:
* Appearance
  * Modify the 'run' method in the 'Tank' class so the tank looks different.
* Driving
  * The current code drives the tank with the WASD keys on the keyboard. Use different keys, such as IJKL or the keypad.
  * Modify 'TankDemo' so it drives with the mouse, using Processing's 'mouseX' and 'mouseY' variables.
  * Add a second tank on the screen that drive with the IJKL keys.
  * Implement a command that will drive the tank forward 200 pixels, turn around, and drive back.  Trigger the command from one of the keys.
  * Implement a command that drives around in a square when some key is pressed.
* Obstacles
  * Change 'Tank' so the tank won't drive off the screen.  It should stop before any of its edges. 
  * Create 'Obstacle' class.  The 'Tank' must stop when it hits an obstacle.  The obstacle should implement the 'ArenaObject' interface.   Make a maze of obstacles.
* Shooting
  * Create a new 'Bullet' class that implements the 'ArenaObject' interface.  The space bar should shoot bullets from the tank.  For now, only allow one 'Bullet' on the screen at once.  Bullets should disappear if they fly more than 300 pixels.
  