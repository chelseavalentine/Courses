package game;
import processing.core.PApplet;

public class Disk extends PApplet {
	//Create the variables that will be the disks' properties
	private int[] values = {10, 20, 50, 100}; //the values that a disk can have inside
	private float value; //the value the disk will take on
	private float size; //the width/height of the ellipse that represents the disk
	private int disappear; //the time before the disk disappears
	private float speed; //the speed at which the disk travels
	private int dirX; //the x direction that the disk will travel
	private int dirY; //the y direction that the disk will travel
	private float posX; //disk x position when generated
	private float posY; //disk y position when generated
	Boolean hardMode; //if it's hard mode, the disks will be smaller & move faster
	
	//Create the default Disk object
	public Disk () {
		//choose one of the values randomly
		value = values[(int)Math.floor(Math.random() * values.length)];
		
		//the size of the disk will be based on the value
		size = value;
		
		//the time it takes for the disk to disappear depends on its value
		disappear = (int)value * 10;
		
		//the disk's speed depends on its value
		speed = value * 10;
		
		//direction will be randomly chosen
		dirX = -5 + (int)Math.floor(Math.random() * 10);
		dirY = -10 + (int)Math.floor(Math.random() * 20);
		
		if (hardMode) {
			size *= 0.5; //disks are smaller
			speed *= 1.25; //and faster
		}
		
		//generate the disks in random positions
		posX = (int)Math.floor(Math.random() * 700);
		posY = (int)Math.floor(Math.random() * 500);
		
		ellipse(posX, posY, size, size);
	}
		
}
