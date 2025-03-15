import java.util.*;

class Course {
    private String name;
    private List<Student> students;
    
    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    
    public void showEnrolledStudents() {
        System.out.println("Course: " + name + " - Enrolled Students:");
        for (Student student : students) {
            System.out.println("\t" + student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;
    
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }
    
    public void showEnrolledCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("\t" + course.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students;
    
    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    
    public void showStudents() {
        System.out.println("School: " + name + " - Students:");
        for (Student student : students) {
            System.out.println("\t" + student.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        
        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);
        
        school.addStudent(student1);
        school.addStudent(student2);
        
        school.showStudents();
        student1.showEnrolledCourses();
        student2.showEnrolledCourses();
        
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}