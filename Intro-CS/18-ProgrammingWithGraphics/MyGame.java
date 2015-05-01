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
 */

public class MyGame extends PApplet {
	public static void main (String args[]) {
		PApplet.main(new String[] { "MyGame"} );
	}
	public void setup(){
		size(500, 500);
	}
	
	public void draw(){
		ellipse( random(0, 500), random(0, 500), 10, 10);
	}
}
