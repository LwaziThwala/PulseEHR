/* PulseEHR
 * @author: Lwazi Thwala
 * @version: 1.0
 * @since: 2025-10-11
 * @description: This is the main class for the Pulse project.
 * It contains the main method and the menu for the Pulse project.  
 * Manages all the necessary classes and methods for the Pulse project.
 */

import java.util.*;
//import java.io.*;

public class Pulse {
    public static void main(String[] args) {
        PatientManager patientManager = new PatientManager();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 2) {
           System.out.println("A Warm Welcome to the PulseEHR");
           System.out.println("--------------------------------------------------");
           System.out.println("Please select an option from the main menu");
           System.out.println("1. Patient Management");
           System.out.println("2. Exit");
           System.out.print("Enter your choice: ");
   
           choice = input.nextInt();
           input.nextLine();
           
           if (choice == 1) {
              int userChoice = 0;
   
           while (userChoice != 6) {
   
               System.out.println("\n----------------------------------------------------------");
               System.out.println("Patient Management");
               System.out.println("----------------------------------------------------------");
               System.out.println("What would you like to do?");
               System.out.println("1. Add a patient");
               System.out.println("2. Remove a patient");
               System.out.println("3. Search for a patient");
               System.out.println("4. Update a patient");
               System.out.println("5. Display all patients");
               System.out.println("6. Back to main menu");
               System.out.print("Enter your choice: ");
   
               int userChoice2 = input.nextInt();
               input.nextLine();
               switch (userChoice2) {
                    case 1:
                            System.out.println("\n----------------------------------------------------------");
                            System.out.println("Add a patient");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Would you like to add patient(s) from a file or manually?");
                            System.out.println("1. Add from file");
                            System.out.println("2. Add manually");
                            System.out.print("Enter your choice: ");

                            int choice2 = input.nextInt();
                            input.nextLine();
                            System.out.println("\n----------------------------------------------------------");
                            if (choice2 == 1) {
                                /*
                                * The format in the file(csv) must be
                                * Name, age, gender, address, phone, email, medicalHistory, medication
                                */

                                System.out.print("Please enter the name of the file: ");
                                String file = input.nextLine();
                                patientManager.loadPatientsFromFile(file);
                                break;
                            }
                                
                            else {
                                System.out.println("Enter the patient's details below");

                                input.nextLine();
                                System.out.print("Name and surname: ");
                                String name = input.nextLine();

                                System.out.print("Date of Birth (yyyy-MM-dd): ");
                                String dateOfBirth = input.nextLine();

                                System.out.print("Gender: ");
                                String gender = input.nextLine();

                                System.out.print("Address: ");
                                String address = input.nextLine();

                                System.out.print("Phone number: ");
                                String phone = input.nextLine();

                                System.out.print("Email: ");
                                String email = input.nextLine();

                                System.out.print("Medical history: ");
                                String medicalHistory = input.nextLine();

                                System.out.print("Medication: ");
                                String medication = input.nextLine();

                                Patient patient = new Patient(name, dateOfBirth, gender, address, phone, email, medicalHistory,
                                        medication);
                                patientManager.addPatient(patient);
                            }
                                System.out.println("Patient successfully added to the system");
                                break;
                            
                        case 2:
                            System.out.println("\n----------------------------------------------------------");
                            System.out.println("Remove a patient");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Enter the patient's name, age and phone number to remove:");
                            input.nextLine(); // consume the newline
                            String name = input.nextLine();
                            String dateOfBirth = input.nextLine();
                            String phone = input.nextLine();
                            patientManager.removePatient(name, dateOfBirth, phone);
                            break;

                        case 3:
                            System.out.println("\n----------------------------------------------------------");
                            System.out.println("Search for a patient");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Enter the patient's name, age and phone number to search for:");
                            input.nextLine(); // consume the newline
                            String name2 = input.nextLine();
                            String dateOfBirth2 = input.nextLine();
                            String phoneNum = input.nextLine();
                            patientManager.searchPatient(name2, dateOfBirth2, phoneNum);
                            break;

                        case 4:
                            System.out.println("\n----------------------------------------------------------");
                            System.out.println("Update a patient");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Enter the details of the patient to update:");
                            input.nextLine();
                            
                            System.out.print("Name and surname: ");
                            String name3 = input.nextLine();
                            System.out.print("Date of birth: ");
                            String age3 = input.nextLine();
                            
                            System.out.print("Medical history: ");
                            String medicalHistory = input.nextLine();
                            System.out.print("Medication: ");
                            String medication = input.nextLine();
                            System.out.print("Phone number: ");
                            String phone2 = input.nextLine();
                            
                            patientManager.updatePatient(name3, age3, medicalHistory, medication, phone2);
                            System.out.println("Patient was successfully updated");
                            break;
                            
                        case 5:
                            System.out.println("\n----------------------------------------------------------");
                            System.out.println("Display all patients");
                            System.out.println("----------------------------------------------------------");
                            patientManager.displayAllPatients();
                        
                        case 6:
                            System.out.println("Returning to main menu...");
                            break;
                            
                       default:
                            System.out.println("Invalid option.");
                            
                    }
                    
                }
                
           } 
           
           else {      
                System.out.println("\n----------------------------------------------------------");
                System.out.println("Thank you for using the PulseEHR");
                System.out.println("----------------------------------------------------------");
                input.close(); 
           }
        }
    }
}
