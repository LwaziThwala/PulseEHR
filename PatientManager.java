/*
 * @author: Lwazi Thwala
 * @version: 1.0
 * @since: 2025-09-17
 * @description: This class is used to manage the patients.
 * It contains a list of patients and a method to add, remove, search, update/edit, display, save and load patients.
 */

import java.util.*;
import java.io.*;

public class PatientManager {
    private ArrayList<Patient> patients;

    public PatientManager() {
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void removePatient(String name, String dateOfBirth, String phoneNum) {
        Patient patient = this.searchPatient(name, dateOfBirth, phoneNum);
        if (patient != null) {
            this.patients.remove(patient);
            System.out.println("Patient successfully removed from the system");
        } else {
            System.out.println("Patient not found in the system");
        }
    }

    public Patient searchPatient(String name, String dateOfBirth, String phone) {
       for (Patient patient : this.patients) {
          if (patient != null ) {
              if ( (patient.getName() != null) && 
                  (patient.getDateOfBirth() != null) &&
                  (patient.getPhone() != null) ) { 
              
                 if ( (patient.getName().equalsIgnoreCase(name)) && 
                    (patient.getDateOfBirth().equals(dateOfBirth)) && 
                    (patient.getPhone().equals(phone)) )
                           {return patient;}
                  }
            }
         }
       return null;
      }

    public void updatePatient(String name, String dateOfBirth, String medicalHistory, String medication, String phoneNum) {
        Patient patient = this.searchPatient(name, dateOfBirth, phoneNum);
        if (patient != null) {
            patient.setMedicalHistory(medicalHistory);
            patient.setMedication(medication);
            this.patients.set(this.patients.indexOf(patient), patient);
            System.out.println("Patient successfully updated in the system");
        } else {
            System.out.println("Patient not found in the system");
        }
    }

    public void displayAllPatients() {
        for (Patient patient : this.patients) {
            System.out.println(patient.toString());
        }
    }
    
    /* 
     * Add a patient if they're not already in the system
     * The format in the file(CSV) must be
     * Name, dateOfBirth, gender, address, phone, email, medicalHistory, medication
     */
    public void loadPatientsFromFile(String fileName) {
        System.out.println("Before loading: " + this.patients.size());
        Scanner data = null;
        try {
            data = new Scanner(new FileReader(fileName));
            int numberOfPatientsAdded = 0;
                
            while (data.hasNextLine()) {;
                String line = data.nextLine().trim();
                 //Skip blank lines
                 if (line.isEmpty()) continue;     
                   
                 String[] fields = line.split(",");
                 if (fields.length != 8) {
                     System.out.println("Skipping invalid line: " + line);
                     continue;
                 } 
                   
                 String name = fields[0].trim();
                 String dateOfBirth = fields[1].trim();                                    
                 String gender = fields[2].trim();
                 String address = fields[3].trim();
                 
                 String phone = fields[4].trim();
                 String email = fields[5].trim();
                 String medicalHistory = fields[6].trim();
                 String medication = fields[7].trim();
                 
                 Patient patient = new Patient(name, dateOfBirth, gender, address, phone, email, medicalHistory, medication);
   
                 if (this.searchPatient(name, dateOfBirth, phone) == null) {
                     this.patients.add(patient);
                     numberOfPatientsAdded++;
                 }
                 else 
                     System.out.println("Patient already exists in the system");
              }
              
           System.out.println("Patients successfully loaded from file: " + fileName);
           System.out.println(numberOfPatientsAdded + " new patients added.");
           }
               
           catch (IOException error) {
               System.out.println("Seems to be an error loading patients from file: " + error.getMessage());
               System.out.println("Please try again");
           }
            
           finally {
               if (data != null) 
                   data.close();
           }
    }
    
    //Write each patient as a single CSV line
    public void savePatientsToFile(String fileName) {
      PrintWriter writer = null;
      try {
        writer = new PrintWriter(new FileWriter(fileName));

        for (Patient p : patients) {
           
                writer.println(
                p.getName() + "," +
                p.getDateOfBirth() + "," +
                p.getGender() + "," +
                p.getAddress() + "," +
                p.getPhone() + "," +
                p.getEmail() + "," +
                p.getMedicalHistory() + "," +
                p.getMedication()
            );
        }

        System.out.println("Patients successfully saved to file: " + fileName);

    } catch (IOException e) {
            System.out.println("Seems to be an error saving patients to file: " + e.getMessage());
            System.out.println("Please try again");
    } finally {
        if (writer != null) {
            writer.close();
        }
    }
    }

}