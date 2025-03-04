package project.uni;

import project.base.Person;

import java.util.ArrayList;

public class PresentedCourse {
    //Fields
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds;

    //Methods
    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        this.studentIds = new ArrayList<>(maxCapacity);
        presentedCourseList.add(this);
        this.id = presentedCourseList.size();
    }

    public static PresentedCourse findById(int ID) {
        for (PresentedCourse presentedCourse : presentedCourseList)
            if (presentedCourse.id == ID)
                return presentedCourse;

        return null;
    }
    public void addStudent(int studentID){
        if (studentIds.size() < capacity) {
            studentIds.add(studentID);
            System.out.println("Student with ID " + studentID + " added to course " + id);
        } else
            System.out.println("Cannot add student. Course " + id + " is full!");
    }
}
