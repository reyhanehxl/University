package project.uni;

import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    //Fields
    public int studentID;
    public HashMap<Integer, Double>transcript;
    //Methods
    public Transcript(int studentID){
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }
    public void setGrade (int presentedCourseID, double grade) {
        PresentedCourse course = PresentedCourse.findById(presentedCourseID);
        if (course != null && course.studentIds.contains(studentID)) {
            transcript.put(presentedCourseID, grade);
            System.out.println("Grade set successfully for student" + studentID);
        }
        else
            System.out.println("Student " + studentID + " is not enrolled in course " + presentedCourseID);
    }
    public void printTranscript() {
        System.out.println("Transcript for Student ID: " + studentID);

        for (int courseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                String courseName = (course != null) ? course.title : "Unknown Course";
                System.out.println(courseName + ": " + transcript.get(courseID));
            }
        }
    }
    public double getGPA() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (int courseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    double grade = transcript.get(courseID);
                    totalPoints += grade * course.units;
                    totalCredits += course.units;
                }
            }
        }

        return (totalCredits == 0) ? 0 : totalPoints / totalCredits;
    }
}