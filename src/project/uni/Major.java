package project.uni;

import project.base.Person;

import java.util.ArrayList;
import java.util.Vector;

public class Major {
    //Fields
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity;
    public int numberOfStudents;

    private static int idCounter = 0;

    //Methods
    public Major(String name, int capacity){
        this.id = idCounter++;
        this.name = name;
        this.capacity = capacity;
        this.numberOfStudents = 0;
        majorList.add(this);
    }
    public static Major findById(int id){
        for(Major major : majorList)
            if(major.id == id)
                return major;

        return null;
    }
    public void addStudent(){
        if(numberOfStudents < capacity) {
            numberOfStudents++;
            System.out.println("Student added to " + name + ". Current number of students: " + numberOfStudents);
        }
        else
            System.out.println("Capacity reached! Cannot add more students to \" + name + \".\"");
    }


}
