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
 *  [1] Create something that generates random disks that have a value on it
 *  [2] Disk properties: value (10, 20, 50, 100), size (ellipse), disappearTime, speed (random),
 *  direction(random), mode (if hard mode, disks move faster or are smaller)
 */


public class MyGame extends PApplet {
	//Game settings
	int disks = 10;
	int counter = 0;
	int maxDisks = 50;
	int currentDisks = 1;
	int score = 0;
	int timer = 0;
	Disk[] allDisks = new Disk[disks];
	Score userScore = new Score();
	
	public static void main (String args[]) {
		PApplet.main(new String[] { "MyGame"} );	
	}

	public void setup(){
		background(0, 0, 0);
		size(700, 500);
		for (int i = 0; i < allDisks.length; i++) {
			allDisks[i] = new Disk(this);
		}
		
	}
	
	public void draw(){	
		counter++;
		timer++;
		if (counter >= 200 && currentDisks < maxDisks && timer!= 6000) {
			currentDisks++;
			counter = 0;
			userScore.score += 1;
		}
//			background(0, 0, 0);
		
		//the disks should move around
		for (int i = 0; i < currentDisks; i++) {
//			allDisks[i].move();
		}
				
		//When the mouse is pressed, if the user has pressed an
		//ellipse, delete the ellipse, generate a new one, and
		//add the value of the ellipse to their score
		
		//If the game has been going on for 60 seconds, stop;
		if (timer == 1000) {
			background(139, 194, 72);
			textSize(40);
			fill(255, 255, 255);
			text("Game Over! You scored:", 120, 175);
			fill(255, 255, 255);
			textSize(75);
			text(userScore.score, 300, 285);
			
		}
	}
	
	class Score {
		int score;
		
		public Score () {
			score = 0;
		}
	}
}

