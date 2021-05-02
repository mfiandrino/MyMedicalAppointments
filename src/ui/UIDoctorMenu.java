package ui;

import models.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu
{
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu()
    {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response)
            {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please, enter a valid option");
            }
        }while (response != 0);
    }


    private static void showAddAvailableAppointmentsMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n::Add Available Appointment");
        int responseDate = 0;
        String date = "";
        do
        {
            System.out.println("Insert the date available: [dd/mm/yyyy]");
            date = sc.nextLine();

            System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
            responseDate = Integer.valueOf(sc.nextLine());
        }while(responseDate == 2);

        int responseTime = 0;
        String time = "";
        do {
            System.out.println("Insert the time available for date: " + date + " [16:00]");
            time = sc.nextLine();
            System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
            responseTime = Integer.valueOf(sc.nextLine());
        }while (responseTime == 2);

        UIMenu.doctorLogged.addAvailableAppointment(date,time);
        checkDoctorAvailableAppointments(UIMenu.doctorLogged);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor)
    {
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor))
        {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
