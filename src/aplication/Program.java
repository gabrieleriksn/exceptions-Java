package aplication;

import java.util.Scanner;
import models.entities.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);  
        
        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation:");
            
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkInUpdate = sdf.parse(sc.next());
            
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOutUpdate = sdf.parse(sc.next());

            // Por que essa solução é ruim?
            // Pois não está respeitando o princípio da delegação!!
            // Deveria ser função da classe reserva checar se os dados fornecidos são condizentes
            // Não no programa principal!!

            if (!checkOutUpdate.after(checkInUpdate) && (!checkInUpdate.after(checkIn) || !checkOutUpdate.after(checkOut))) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates and Check-out date must be after check-in date");
            }
            
            else if (!checkOutUpdate.after(checkInUpdate)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }

            else if (!checkInUpdate.after(checkIn) || !checkOutUpdate.after(checkOut)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            
            else {
                reservation.updateDates(checkInUpdate, checkOutUpdate);
                System.out.println(reservation);
            }
        }
        

        sc.close();
    }
}
