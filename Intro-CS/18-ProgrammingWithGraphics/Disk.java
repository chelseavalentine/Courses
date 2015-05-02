package game;
import processing.core.PApplet;

public class Disk {
	//Create the variables that will be the disks' properties
	protected int[] values = {10, 20, 50, 100}; //the values that a disk can have inside
	protected float value; //the value the disk will take on
	protected float size; //the width/height of the ellipse that represents the disk
	protected int disappear; //the time before the disk disappears
	protected float speed; //the speed at which the disk travels
	protected float dirX; //the x direction that the disk will travel
	protected float dirY; //the y direction that the disk will travel
	protected float posX; //disk x position when generated
	protected float posY; //disk y position when generated
	protected int alive; //the time the disk has spent alive
	protected String text;
	protected Boolean hide = false;
	PApplet canvas;
	protected int textSize;
	
	//Create the default Disk object
	public Disk ( PApplet canvas, Boolean hardMode) {
		this.canvas = canvas;
		
		//choose one of the values randomly
		value = values[(int)Math.floor(Math.random() * values.length)];
		
		//the size of the disk will be based on the value
		size = value * 3;
		
		//the time it takes for the disk to disappear depends on its value
		disappear = (int)((100/value) * 1000);
		
		//the disk's speed depends on its value
		speed = value * 5;
		
		//direction will be randomly chosen
		dirX = canvas.random(-5, 5);
		dirY = canvas.random(-5, 5);
		
		if (hardMode) {
			size *= 0.5; //disks are smaller
			speed *= 1.25; //and faster
		}
		
		//generate the disks in random positions
		posX = canvas.random(0, canvas.width);
		posY = canvas.random(0, canvas.height);
		
		this.canvas.fill( canvas.random(20, 255), canvas.random(20, 255), canvas.random(20, 255));
		this.canvas.ellipse(posX, posY, size, size);
		
		//show the value of the disk
		textSize = 24;
		text = Float.toString(value);
		this.canvas.fill(255, 255, 255);
		this.canvas.textSize(textSize);
		this.canvas.text(text, posX, posY);
	}
		
	public void move() {
		this.posX += this.dirX;
		this.posY += this.dirY;
		
		// bouncing logic - see if the ball hits any of the edges
		if (posX > canvas.width) {
			posX = canvas.width;
			dirX *= -1;
		}
		
		if (posX < 0) {
			posX = 0;
			dirX *= -1; 
		}
		
		if (posY > canvas.height) {
			posY = canvas.height;
			dirY *= -1;
		}
		
		if (posY < 0) {
			posY = 0;
			dirY *= -1; 
		}

		this.canvas.fill(canvas.random(10, 255), canvas.random(10, 255), 255);
		this.canvas.ellipse(posX, posY, size, size);
		this.canvas.fill(255, 255, 255);
		
		if (this.hide) {
			this.canvas.text((int)this.value, -100, -100);
		}
		else {
			this.canvas.text((int)this.value, posX-15, posY+10);
		}
	}
	
	
}
