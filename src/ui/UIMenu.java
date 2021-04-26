package ui;

import models.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu
{
    public static Doctor doctorLogged;

    public static void showMenu()
    {
        System.out.println("Welcome to My Appointments");
        System.out.println("Choose an option");

        int response = 0;
        do
        {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response)
            {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;

                case 2:
                    response = 0;
                    authUser(2);
                    break;

                case 0:
                    System.out.println("Thank you for you visit");
                    break;

                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    private static void authUser(int userType)
    {
        //userType = 1 Doctor
        //userType = 2 Patient

        //----SIMULATES A DATABASE----//
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Max Verstappen", "maxVerstappen@mail.com"));
        doctors.add(new Doctor("Lando Norris", "landoNorris@mail.com"));
        doctors.add(new Doctor("Alex Albon", "alexAlbon@mail.com"));
        /*
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("John Travolta", "JohnTra@mail.com"));
        patients.add(new Patient("Charles Chaplin", "charlesChaplin@mail.com"));
        patients.add(new Patient("Michael Burry", "michaelBurry@mail.com"));
        */

        boolean emailCorrect = false;
        do
        {
            System.out.println("Insert your email: \"a@a.com\"");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1)
            {
                for (Doctor d : doctors)
                {
                    if (d.getEmail().equals(email))
                    {
                        emailCorrect = true;
                        doctorLogged = d;
                        //Go to doctor menu
                    }
                }
            }
            if (userType == 2)
            {
                System.out.println("Sorry, this section will be ready soon");
                emailCorrect = true;
            }
        } while (!emailCorrect);
    }
}
