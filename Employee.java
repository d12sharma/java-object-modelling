import java.util.*;

class Employee {
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public void showEmployeeDetails() {
        System.out.println("\tEmployee: " + name);
    }
}

class Department {
    private String name;
    private List<Employee> employees;
    
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }
    
    public void showDepartmentDetails() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.showEmployeeDetails();
        }
    }
}

class Company {
    private String name;
    private List<Department> departments;
    
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    
    public Department getDepartment(String deptName) {
        for (Department dept : departments) {
            if (deptName.equals(deptName)) {
                return dept;
            }
        }
        return null;
    }
    
    public void showCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showDepartmentDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        
        company.addDepartment("IT");
        company.addDepartment("HR");
        
        Department itDept = company.getDepartment("IT");
        Department hrDept = company.getDepartment("HR");
        
        if (itDept != null) {
            itDept.addEmployee("Alice");
            itDept.addEmployee("Bob");
        }
        
        if (hrDept != null) {
            hrDept.addEmployee("Charlie");
        }
        
        company.showCompanyDetails();
    }
}
