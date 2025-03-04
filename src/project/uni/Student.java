package project.uni;

import java.util.ArrayList;
import project.uni.Major;

public class Student {
    //Fields
    public int id;
    public static ArrayList<Student>studentList = new ArrayList<>();
    public int personID;
    public final int enteranceYear;
    public int majorID;
    public String studentID;

    private static int idCounter = 0;


    //Methods
    public Student(int personID, int entranceYear, int majorID){
        this.id = idCounter++;
        this.personID = personID;
        this.enteranceYear = entranceYear;
        this.majorID = majorID;
        Major major = Major.findById(majorID);
        major.addStudent();
        setStudentCode(major.numberOfStudents);
        studentList.add(this);

    }
    public static Student findByid(int id){
        for(Student student : studentList)
            if(student.id == id)
                return student;

        return null;
    }
    public void setStudentCode(int studentNumber){
        this.studentID = enteranceYear + String.format("%02d",majorID) + String.format("%02d", studentNumber) ;
    }

}
