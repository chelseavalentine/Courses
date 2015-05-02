package game;
import processing.core.PApplet;

/**
 * @title Programming with Graphics
 * @author Chelsea Valentine
 * @date May 1, 2015
 * 
 * @assignment:
 * Implement a game in which the user has to collect points by clicking on moving disks.
 * Each disk should have its own value associated with it (10, 20, 50, 100). 
 * The value of each disk should be displayed inside of the moving disk. 
 * Each disk should move at its own rate and direction.
 * The disks disappear after some time 
 * The user collects points by clicking on disks. 
 * Your program should detect if the user successfully clicked on a disk. 
 * If the user successfully clicks on the disk, the disk’s point value is added to the user’s
 * total and the disk should disappear. 
 * The game should last 1 minute. After one minute the total value of points collected should be displayed.
 * You can divide the game into levels: in each consecutive level the disks become 
 * harder to click on (get smaller or get faster, or some combination of both) 
 */

public class MyGame extends PApplet {
	
	//Game settings
	int disks = 10;
	int counter = 0;
	int timer = 0;
	Disk[] allDisks = new Disk[disks];
	Score stats = new Score();
	boolean asked = false;
	boolean hardMode = false;
	
	public static void main (String args[]) {
		PApplet.main(new String[] { "MyGame"} );	
	}

	//set up what the applet will look like when it's first loaded
	public void setup(){
		size(700, 500);
		background(0, 0, 0);
		fill(255, 255, 255);
		textSize(32);
		text("Choose a mode:\n\n Easy [left key]\n Hard [right key]", 225, 175);
		
	}
	
	public void draw(){	
		//Check which difficulty level the user wants to play at
		if (keyPressed && (keyCode == LEFT || keyCode == RIGHT)) {
			asked = true;
			//if the left key was played, let's do the easy mode
			if (keyCode == LEFT) {
				//generate the disks for our game
				for (int i = 0; i < allDisks.length; i++) {
					allDisks[i] = new Disk(this, hardMode);
				}
			}
			//otherwise, let's do the hard mode
			else {
				//generate the disks for our game
				for (int i = 0; i < allDisks.length; i++) {
					hardMode = true;
					allDisks[i] = new Disk(this, hardMode);
				}
			}
			
			background(0, 0, 0); //clear the mess that is created by generating disks
		}
		
		//Don't start playing the game until the user has finally answered the question
		//of which difficulty level they want to play at
		if (asked) {
			counter++; //count when we should create a new disk
			timer++; //keep track of how much time the user has been playing for
			
			if (counter >= 100 && timer!= 600) {
				stats.currentDisks++; //a new disk has been made, so let's keep track of total
				counter = 0;
			}
			
			background(0, 0, 0); //make the screen black so we don't get trailing circles
			
			//Let's play until 60 seconds have gone by
			if (timer < 6000) {
				//give the disks life by moving them around
				for (int i = 0; i < stats.currentDisks && i < allDisks.length; i++) {
					allDisks[i].move();
					
					//check whether it's time for the disk to disappear~
					disappear(allDisks[i]);
				}
				
			}
			else {
				//If the game has been going on for 60 seconds, stop;
				background(139, 194, 72); //light green background
				textSize(40);
				fill(255, 255, 255);
				
				//display the user's results
				text("Game Over! You scored:", 120, 175); 
				fill(255, 255, 255);
				textSize(75);
				text(stats.score, 300, 285);	
			}
			
			//When the mouse is pressed, if the user has pressed an ellipse, 
			//delete the ellipse, & add the value of the ellipse to their score
			if (mousePressed) {
				//go through each of the disks
				for (int i = 0; i < stats.currentDisks && i < allDisks.length; i++) {
					//check whether the mouse click was in that object
					if (dist(mouseX, mouseY, allDisks[i].posX, allDisks[i].posY) < (allDisks[i].size)/2) {
						//yes it was, so add the value of the disk to the score & delete the disk
						stats.score += (int)allDisks[i].value;
						delete(allDisks[i]);
					}
				}
			}
			
			//If all of the disks have gone away, let's make new ones so we can
			//keep playing
			if (stats.disappearances == 10) {
				stats.currentDisks = 0; //reset the current amount of disks
				//create a new set of disks to play with
				for (int i = 0; i < allDisks.length; i++) {
					allDisks[i] = new Disk(this, hardMode);
				}
				stats.disappearances = 0; //reset the number of disappearances
				background(0, 0, 0); //hide the disk creation
			}
		}	
	}
	
	/** Check whether it is time for a disk to expire/go away. If it is, remove it.
	 * @param disk the disk that could expire
	 */
	public void disappear(Disk disk) {
		disk.alive += 10; //accurately reflect how long the disk has been alive
		
		//if it has been alive for the amount of time before it needs to die, kill this disk
		if (disk.alive == disk.disappear) {
			disk.size = 0; //Make the disk so small that you can't see it.
			stats.currentDisks--; //reflect that there're less disks in the total
			disk.hide = true; //the disk is in hide mode, so let's make move() not work on it
			stats.disappearances++; //increase the number of disappearances so we know when to regenerate
		}		
	}	
	
	/** Remove a disk from sight when the user has successfully clicked on it.
	 * @param disk the disk that we're getting rid of
	 */
	public void delete(Disk disk) {		
		disk.size = 0; //Make the disk so small that you can't see it.
		stats.currentDisks--; //reflect that there're less disks in the total
		disk.hide = true; //the disk is in hide mode, so let's make move() not work on it
		stats.disappearances++; //increase the number of disappearances so we know when to regenerate
	}	
	
	//Create a Score object to keep track of all of the game statistics
	public class Score {
		protected int score; //the user's score
		protected int currentDisks; //the number of disks that're currently in play
		protected int disappearances; //the amount of disks that have expired/been successfully clicked on
		
		//the typical score object
		public Score () {
			score = 0;
			currentDisks = 0;
			disappearances = 0;
		}
	}	
}
