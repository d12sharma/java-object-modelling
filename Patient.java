import java.util.*;

class Patient {
    private String name;
    private List<Doctor> doctors;
    
    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }
    
    public void showDoctors() {
        System.out.println("Patient: " + name + " - Consulted Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("\t" + doctor.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;
    
    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }
    
    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            addPatient(patient);
            patient.addDoctor(this);
        }
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName());
    }
    
    public void showPatients() {
        System.out.println("Doctor: " + name + " - Patients:");
        for (Patient patient : patients) {
            System.out.println("\t" + patient.getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;
    
    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }
    
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }
    
    public void showDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("\t" + doctor.getName());
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("\t" + patient.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        
        Doctor doc1 = new Doctor("Dr. Smith");
        Doctor doc2 = new Doctor("Dr. Johnson");
        
        Patient pat1 = new Patient("Alice");
        Patient pat2 = new Patient("Bob");
        
        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(pat1);
        hospital.addPatient(pat2);
        
        doc1.consult(pat1);
        doc1.consult(pat2);
        doc2.consult(pat1);
        
        hospital.showDetails();
        doc1.showPatients();
        doc2.showPatients();
        pat1.showDoctors();
        pat2.showDoctors();
    }
}