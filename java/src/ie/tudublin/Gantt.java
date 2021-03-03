package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	

	//calling an array list to hold the instances of the class
	ArrayList<Task> tasks = new ArrayList<Task>(); //creating an object
	
	public void settings()
	{
		size(800, 600);
	}


	// drawing vertical lines 
	public void displayTasks() {
	

		textAlign(CENTER,CENTER);
		float border = 0.1f * width;
		for(int i = 1 ; i <= 30 ; i++){
			

			float x = map(i, 1, 30, border, width - border); // for x-axis numbers on top
			
			stroke(255);
			line(x, border, x,  height - border);// y axis

			// getting the text to align with bars at the top of the screen
			fill(255);
			text(i,x, border*0.5f);
			

		}//end for loop

		for( int j = 0; j < tasks.size(); j++){
			//creating an object
			Task t = tasks.get(j);
			float y = map(t.getTask(),0, 30, border, height - border); // to display text along the side
			//text aligned at the left
			text(j, border * 0.5f, y);

		}

	}//endd method

	// this method populates the arraylist from the file tasks.csv
	public void loadTasks()
	{
		
		//loading the table
		Table table = loadTable("tasks.csv", "header");
		
		// enhanced for loop - iterating over the table row by row
		for(TableRow row:table.rows()){

			Task t = new Task(row); //creating object
			tasks.add(t);


		}//end for 
	}//end method

	// this method used to print the array list and printing it to the console
	public void printTasks()
	{
		for(Task t: tasks){
			println(t);
		}//end for
	}//end method
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
