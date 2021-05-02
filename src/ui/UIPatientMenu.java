package ui;

import models.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

public class UIPatientMenu
{
    public static void showPatientMenu()
    {
        int response = 0;
        do {
            System.out.println("\n\nPatient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response)
            {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please, enter a valid option");
            }
        }while (response!=0);
    }

    private static void showBookAppointmentMenu()
    {
        System.out.println("::Book an appointment");
        System.out.println(":: Select a doctor: ");

        //Muestro los doctores disponibles
        for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++)
        {
            System.out.println(i+1 + ". " + UIDoctorMenu.doctorsAvailableAppointments.get(i).getName());
        }
        System.out.println("0. Return");


        //Capturo el doctor que quiere el paciente
        Scanner sc = new Scanner(System.in);
        int doctorResponse = Integer.valueOf(sc.nextLine()) - 1;
        if(doctorResponse == -1)
            return;
        Doctor doctorSelected = UIDoctorMenu.doctorsAvailableAppointments.get(doctorResponse);
        System.out.println("Doctor " + doctorSelected.getName());

        //Muestro las citas disponibles del doctor seleccionado
        ArrayList<Doctor.AvailableAppointment> availableAppointments = doctorSelected.getAvailableAppointments();
        for (int i = 0; i < availableAppointments.size() ; i++)
        {
            System.out.println("\t" + (i+1) + ". " + availableAppointments.get(i).getDate() + "\t" + availableAppointments.get(i).getTime());
        }
        System.out.println("\t0. Return");

        //Capturo la cita que quiere el paciente
        int appointmentResponse = Integer.valueOf(sc.nextLine()) - 1;
        if(appointmentResponse == -1)
            return;
        Doctor.AvailableAppointment appointmentSelected = availableAppointments.get(appointmentResponse);


        System.out.println( "Doctor: " + doctorSelected.getName() +
                            "Appointment: " + appointmentSelected.getDate() + "\t" + appointmentSelected.getTime());
        System.out.println("1. Confirm\n0. Decline");
        int confirmResponse = Integer.valueOf(sc.nextLine());
        if(confirmResponse == 1)
        {
            UIMenu.patientLogged.addAppointmentDoctors(doctorSelected, appointmentSelected.getDate(null), appointmentSelected.getTime());
        }
    }

    private static void showPatientMyAppointments()
    {
        System.out.println("::My Appointments");
        if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0)
        {
            System.out.println("Don't have appointments");
           return;
        }

        for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++)
        {
            int j = i + 1;
            System.out.println(j + ". " +
                    "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                    " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                    "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
            );
        }
    }
}
