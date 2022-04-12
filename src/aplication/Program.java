package aplication;

import models.exception.DomainException;
import java.util.Scanner;
import models.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation:");
            
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkInUpdate = sdf.parse(sc.next());
            
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOutUpdate = sdf.parse(sc.next());

            reservation.updateDates(checkInUpdate, checkOutUpdate);
            System.out.println(reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format!");
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected error.");
        }
        finally {
            sc.close();
        }
    }
}
