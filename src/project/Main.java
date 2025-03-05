package project;

import project.base.Person;
import project.uni.Major;
import project.uni.Professor;
import project.uni.Student;
import project.uni.Transcript;
import project.uni.PresentedCourse;
import project.uni.Course;

public class Main {
    public static void main(String[] args) {

        Major major1 = new Major("Computer Science",6);
        Major major2 = new Major("Mathematics", 7);

        Person p1 = new Person("HashMat", "333");
        Person p2 = new Person("HashPat", "666");
        Person p3 = new Person("HasRat", "999");
        Person p4 = new Person("Dr. DOC1", "321");
        Person p5 = new Person("Dr. DOC2", "123");

        Student s1 = new Student(1, 403, major1.id);
        Student s2 = new Student(2, 403, major1.id);
        Student s3 = new Student(3, 403, major2.id);

        System.out.println("Students:");
        System.out.println(p1.name + " - Student ID: " + s1.studentID);
        System.out.println(p2.name + " - Student ID: " + s2.studentID);
        System.out.println(p3.name + " - Student ID: " + s3.studentID);

        Professor prof1 = new Professor(4, major1.id);
        Professor prof2 = new Professor(5, major2.id);

        System.out.println("\nProfessors:");
        System.out.println("Professor ID: " + prof1.id + " - Name: " + p4.name);
        System.out.println("Professor ID: " + prof2.id + " - Name: " + p5.name);

        Course c1 = new Course("Advanced Programming", 3);
        Course c2 = new Course("Data Structures", 3);
        Course c3 = new Course( "Calculus", 4);

        PresentedCourse pc1 = new PresentedCourse(c1.id, prof1.id, 10);
        PresentedCourse pc2 = new PresentedCourse(c2.id, prof1.id, 10);
        PresentedCourse pc3 = new PresentedCourse(c3.id, prof2.id, 10);

        pc1.addStudent(s1.id);
        pc1.addStudent(s2.id);
        pc2.addStudent(s1.id);
        pc2.addStudent(s2.id);
        pc2.addStudent(s3.id);
        pc3.addStudent(s3.id);

        Transcript t1 = new Transcript(s1.id);
        Transcript t2 = new Transcript(s2.id);
        Transcript t3 = new Transcript(s3.id);

        t1.setGrade(pc1.id, 18.5);
        t1.setGrade(pc2.id, 17.0);
        t2.setGrade(pc1.id, 19.0);
        t2.setGrade(pc2.id, 16.5);
        t3.setGrade(pc2.id, 15.0);
        t3.setGrade(pc3.id, 17.5);

        System.out.println("\nTranscripts:");
        t1.printTranscript();
        t2.printTranscript();
        t3.printTranscript();

        System.out.println("\nGPAs:");
        System.out.println(p1.name + " - GPA: " + t1.getGPA());
        System.out.println(p2.name + " - GPA: " + t2.getGPA());
        System.out.println(p3.name + " - GPA: " + t3.getGPA());
    }
}
