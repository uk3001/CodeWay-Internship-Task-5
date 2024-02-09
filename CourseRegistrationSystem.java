package StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Course{
	private String Code;
	private String Title;
	private String Description;
	private int Capacity;
	private String Schedule;
	private int EnrolledStudents;
	
	public Course(String Code, String Title, String Description, int Capacity, String Schedule, int EnrolledStudents)
	{
		this.Code=Code;
		this.Title=Title;
		this.Description=Description;
		this.Capacity=Capacity;
		this.Schedule=Schedule;
		this.EnrolledStudents=0;
	}

	public String getCode() {
		return Code;
	}

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public int getCapacity() {
		return Capacity;
	}

	public String getSchedule() {
		return Schedule;
	}

	public int getEnrolledStudents() {
		return EnrolledStudents;
	}
	
	public boolean AddStudents()
	{
		if(EnrolledStudents < Capacity)
		{
			EnrolledStudents++;
			return true;
		}
		return false;
	}
	
	public void RemoveStudent()
	{
		if(EnrolledStudents > 0)
		{
			EnrolledStudents--;
		}
	}
}

class Student
{
	private String id;
	private String Name;
	private List<Course> RegisteredCourses;
	
	public Student(String id, String name) {
		this.id = id;
		this.Name = name;
		this.RegisteredCourses = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public List<Course> getRegisteredCourses() {
		return RegisteredCourses;
	}
	
	public void RegisterCourse(Course course)
	{
		if(course.AddStudents())
		{
			RegisteredCourses.add(course);
		}
		else
		{
			System.out.println("Course "+course.getCode()+" is full.");
		}
	}
	
	public void DropCourse(Course course)
	{
		if(RegisteredCourses.remove(course))
		{
			course.RemoveStudent();
		}
		else
		{
			System.out.println("Course "+course.getCode()+" is not Registered by student "+id);
		}
	}	
}

public class CourseRegistrationSystem {

	public static void main(String args[])
	{
		Course JavaCourse = new Course("CS101", "Java Programming", "Introduction to Java programming language", 30, "Mon/Fri 10:00-12:00",  0);
		Course DatabaseCourse = new Course("CS102", "Database Management", "Introduction to Database Management Sytems", 25, "Mon/Fri 1:00-3:00", 0);
		
//		Student student1 = new Student("S01", "Kunal");
//		Student student2 = new Student("S01", "Makrand");
//		
//		student1.RegisterCourse(JavaCourse);
//		student2.RegisterCourse(DatabaseCourse);
//		
//		student2.RegisterCourse(JavaCourse);
//		
//		System.out.println("Courses registered by "+student1.getName()+" : ");
//		for(Course course : student1.getRegisteredCourses())
//		{
//			System.out.println(course.getCode()+" - "+course.getTitle());
//		}
//		
//		System.out.println("Courses registered by "+student2.getName()+" : ");
//		for(Course course:student2.getRegisteredCourses())
//		{
//			System.out.println(course.getCode()+" - "+course.getTitle());
//		}
		
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Student Id : ");
		String Id=s.nextLine();
		System.out.println("Enter Student Name : ");
		String Name=s.nextLine();
		Student student1 = new Student(Id, Name);
		
		System.out.println("Availabel Courses:"+"\n"+"1. Java Course"+"\n"+"2. Database Course"+"\n"+"Enter Choice");
		int Choice=s.nextInt();
		
		switch(Choice)
		{
			case 1:
				System.out.println();
				student1.RegisterCourse(JavaCourse);
				JavaCourse.AddStudents();
				System.out.println("Enrolled Successfully!");
				break;
			case 2:
				student1.RegisterCourse(DatabaseCourse);
				DatabaseCourse.AddStudents();
				System.out.println("Enrolled Successfully!");
				break;
			default:
				System.out.println("Invalid  Choice!");
				break;
		}
		
	}
}
