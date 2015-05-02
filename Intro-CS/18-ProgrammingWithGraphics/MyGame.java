package game;
import processing.core.PApplet;

/**
 * @title Programming with Graphics
 * @author Chelsea Valentine
 * @date May 1, 2015
 * 
 * @assignment:
 * 
 * 
 * Implement a game in which the user has to collect points by clicking on moving disks.
 * Each disk should have its own value associated with it (possible values should be 10,
 * 20, 50, 100). The value of each disk should be displayed inside of the moving disk. 
 * Each disk should move at its own rate and direction. (Hint: you should have a Disk class.)
 * The disks disappear after some time (you could make disks of with the higher value 
 * disappear much faster than the disks of the larger values. The user collects points by 
 * clicking on disks. Your program should detect if the user successfully clicked on a disk.
 * If the user successfully clicks on the disk, the disk’s point value is added to the user’s
 * total and the disk should disappear. The game should last 1 minute. After one minute the
 * total value of points collected should be displayed. Note: Make sure that the disks are
 * large enough for a human user (read: your instructor) to click on. Make sure that the 
 * disks are moving slow enough so that a human user can click them, but also fast enough
 * so that the game is challenging. You can divide the game into levels: in each consecutive 
 * level the disks become harder to click on (get smaller or get faster, or some combination
 * of both)
 * 
 */


public class MyGame extends PApplet {
	//Game settings
	int disks = 10;
	int counter = 0;
	int maxDisks = 50;
	int score = 0;
	int timer = 0;
	int redraw = 0;
	Disk[] allDisks = new Disk[disks];
	Score stats = new Score(this);
	boolean asked = false;
	boolean hardMode = false;
	
	public static void main (String args[]) {
		PApplet.main(new String[] { "MyGame"} );	
	}

	public void setup(){
		size(700, 500);
		background(0, 0, 0);
		fill(255, 255, 255);
		textSize(32);
		text("Choose a mode:\n\n Easy [left key]\n Hard [right key]", 225, 175);
		
	}
	
	public void draw(){	
		if (keyPressed && (keyCode == LEFT || keyCode == RIGHT)) {
			asked = true;
			if (keyCode == 37) {
				for (int i = 0; i < allDisks.length; i++) {
					allDisks[i] = new Disk(this, hardMode);
				}
			}
			else {
				for (int i = 0; i < allDisks.length; i++) {
					hardMode = true;
					allDisks[i] = new Disk(this, hardMode);
				}
			}
			background(0, 0, 0);
		}
		
		if (asked) {
			counter++;
			timer++;
			
			if (counter >= 100 && stats.currentDisks < maxDisks && timer!= 600) {
				stats.currentDisks++;
				counter = 0;
			}
			
			background(0, 0, 0);
			
			if (timer < 6000) {
				//the disks should move around
				for (int i = 0; i < stats.currentDisks && i < allDisks.length; i++) {
					allDisks[i].move();
					
					//check whether it's time for the disk to disappear~
					disappear(allDisks[i]);
				}
				
			} else {
				//If the game has been going on for 60 seconds, stop;
				background(139, 194, 72);
				textSize(40);
				fill(255, 255, 255);
				text("Game Over! You scored:", 120, 175);
				fill(255, 255, 255);
				textSize(75);
				text(stats.score, 300, 285);	
			}
			
			//When the mouse is pressed, if the user has pressed an
			//ellipse, delete the ellipse, generate a new one, and
			//add the value of the ellipse to their score
			if (mousePressed) {
				//Check whether the mouse location was in an object
				for (int i = 0; i < stats.currentDisks && i < allDisks.length; i++) {
					if (dist(mouseX, mouseY, allDisks[i].posX, allDisks[i].posY) < (allDisks[i].size)/2) {
						stats.score += (int)allDisks[i].value;
						delete(allDisks[i]);
					}
				}
			}
			
			if (stats.disappearances == 10) {
				stats.currentDisks = 0;
				for (int i = 0; i < allDisks.length; i++) {
					allDisks[i] = new Disk(this, hardMode);
				}
				stats.disappearances = 0;
				background(0, 0, 0);
			}
		}
		
	}
	
	PApplet canvas;
	public class Score {
		int score;
		int currentDisks;
		int disappearances;
		
		public Score (PApplet canvase) {
			canvas = canvase;
			score = 0;
			currentDisks = 0;
			disappearances = 0;
		}
	}
	
	public void disappear(Disk disk) {
		disk.alive += 10;
		
		if (disk.alive == disk.disappear) {
			disk.size = 0;
			stats.currentDisks--;
			disk.hide = true;
			stats.disappearances++;
		}		
	}	
	
	public void delete(Disk disk) {		
		disk.size = 0;
		stats.currentDisks--;
		disk.hide = true;
		stats.disappearances++;
	}	
	
}
