package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
public class Task {
    
    //creating private vars
    private boolean task;
    private int start;
    private int end;
    

    //create default constructor
    public Task(TableRow row){

        //constructor chaining -  this is linking constructors together
        // this calls the constructor below 
        this(row.getInt("Task")==1 ? true : false,
        row.getInt("Start"),
        row.getInt("End")
        );


    }//end constructor

    //creating a parameterised constructor
    public Task(boolean task, int start, int end){
        this.task = task;
        this.start = start;
        this.end = end;
        
    }//end constructor



    // ACCESSOR METHODS - getters and setters
    public boolean getTask() {
        return task;
    }//end getter

    public void setTask(boolean task) {
        this.task = task;
    }//end setter

    public int getStart() {
        return start;
    }//end getter

    public void setStart(int start) {
        this.start = start;
    }// end setter

    public int getEnd() {
        return end;
    }//end getter

    public void setEnd(int end) {
        this.end = end;
    }//end setter

    // generating a toString method to print out the values 
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", task=" + task + "]";
    }






}//end class
