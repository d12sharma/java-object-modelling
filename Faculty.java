import java.util.*;

class Faculty {
    private String name;
    
    public Faculty(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    
    public Department(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;
    
    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }
    
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    
    public void showDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("\t" + dept.getName());
        }
        System.out.println("Faculties:");
        for (Faculty fac : faculties) {
            System.out.println("\t" + fac.getName());
        }
    }
    
    public void deleteUniversity() {
        departments.clear(); // Deleting University deletes all Departments
        System.out.println("University and all Departments deleted!");
    }
}

public class Main {
    public static void main(String[] args) {
        University university = new University("Tech University");
        
        university.addDepartment("Computer Science");
        university.addDepartment("Electrical Engineering");
        
        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Prof. Johnson");
        
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        
        university.showDetails();
        
        // Deleting university
        university.deleteUniversity();
    }
}