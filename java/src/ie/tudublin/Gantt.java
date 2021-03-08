package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	

	//calling an array list to hold the instances of the class
	ArrayList<Task> tasks = new ArrayList<Task>(); //creating an object
	
	//border vars
	private float leftBorder;
	private float rightBorder;

	//move box vars
	int whichTask  = 1; // which task is being clicked
	boolean isEnd = false;

	public void mousePressed(){
		for(int i=0; i< tasks.size(); 
	}//end method


	public void settings()
	{
		size(800, 600);
		
	}


	// drawing vertical lines 
	public void displayTasks() {
	

		textAlign(CENTER,CENTER);
		stroke(255);
		for(int i = 1 ; i <= 30 ; i++){
			

			float x = map(i, 1, 30, leftBorder, width - rightBorder); // for x-axis numbers on top
			
			line(x, rightBorder, x,  height - rightBorder);// y axis

			// getting the text to align with bars at the top of the screen
			fill(255);
			text(i,x, rightBorder/2);
			

		}//end for loop


		// getting number of elements in array list
		for( int j = 0; j < tasks.size(); j++){
			float y = map(j,0,tasks.size(), rightBorder + 50, height - rightBorder - 50);
			//creating an object
			Task t = tasks.get(j);
			//calculating start point and end point
			float x1 = map(t.getStart(),1, 30, leftBorder, width - rightBorder);
			float x2 = map(t.getEnd(), 1, 30, leftBorder, width - rightBorder);

			
			// setting a colour
			int colour = (int)map(j, 0, tasks.size(), 0, 255);
			noStroke();
			fill(colour, 255, 255);
			rect(x1, y - 20, x2 - x1, 40);

			// setting the text at the left side of the screen
			fill(255);
			textAlign(LEFT, CENTER);
			text(t.getTask(), leftBorder /2, y);

		}

	}//endd method

	// this method populates the arraylist from the file tasks.csv
	public void loadTasks()
	{
		
		//loading the table - header to indicaye the first row has the headers of the file
		Table table = loadTable("tasks.csv", "header");
		
		// enhanced for loop - iterating over the table row by row
		for(TableRow row:table.rows()){

			Task t = new Task(row); //creating object
			tasks.add(t); // adding the tasks to the array list


		}//end for 
	}//end method

	// this method used to print the array list and printing it to the console
	public void printTasks()
	{
		for(Task t: tasks){
			println(t);
		}//end for
	}//end method
	
	public void setup() 
	{
		loadTasks();
		printTasks();
		leftBorder = width * 0.2f;;
		rightBorder = width * 0.05f;
		colorMode(HSB);
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
