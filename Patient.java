/*
 * Patient class for PulseEHR project
 * @author: Lwazi Thwala
 * @version: 1.0
 * @since: 2025-09-17
 * @description: This is the Patients class for the Pulse project.
 * It contains all the information and methods that a Patient has. 
 */

public class Patient {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String medicalHistory;
    private String medication;

    public Patient(String name, String dateOfBirth, String gender, String address, String phone, String email, String medicalHistory, String medication) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.medicalHistory = medicalHistory;
        this.medication = medication;
    }

    public Patient() {
        this.name = "";
        this.dateOfBirth = "";
        this.gender = "";
        this.address = "";
        this.phone = "";
        this.email = "";
        this.medicalHistory = "";
        this.medication = "";
    }

    public Patient(Patient patient) {
        this.name = patient.name;
        this.dateOfBirth = patient.dateOfBirth;
        this.gender = patient.gender;
        this.address = patient.address;
        this.phone = patient.phone;
        this.email = patient.email;
        this.medicalHistory = patient.medicalHistory;
        this.medication = patient.medication;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setAge(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
    
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    
    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String toString() {
        return "Patient details \nName: " + name + "\nDate of birth: " + dateOfBirth + "\nGender: " + gender + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: " + email + "\nMedical History: " + medicalHistory + "\nMedication: " + medication + "\n";
    }

}
