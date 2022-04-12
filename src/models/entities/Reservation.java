package models.entities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer duration() {
        // Se fazemos getTime() em um objeto do tipo Date nos é
        // retornado um valor long que representa a qtd em milissegundos

        long durationMillis = checkOut.getTime() - checkIn.getTime();
        return (int) durationMillis / (24 * 60 * 60 * 1000);
        
        // return TimeUnit.DAYS.convert(durationMillis, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "Reservation : Room " 
               + roomNumber 
               + ", check-in: " 
               + sdf.format(checkIn) 
               + ", check-out: " 
               + sdf.format(checkOut) 
               + ", " + duration() 
               + " nights";
    }

}
