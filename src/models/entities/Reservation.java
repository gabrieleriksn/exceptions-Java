package models.entities;

import java.util.Date;
import models.exception.DomainException;
import java.text.SimpleDateFormat;

public class Reservation {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {

        if (checkOut.before(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

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

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn) && (!checkIn.after(this.checkIn) || !checkOut.after(this.checkOut))) {
            throw new DomainException("Reservation dates for update must be future dates and Check-out date must be after check-in date");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        if (!checkIn.after(this.checkIn) || !checkOut.after(this.checkOut)) {
            throw new IllegalArgumentException("Reservation dates for update must be future dates");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duration() {
        // Se fazemos getTime() em um objeto do tipo Date nos é
        // retornado um valor long que representa a qtd em milissegundos

        long durationMillis = checkOut.getTime() - checkIn.getTime();
        return durationMillis / (24 * 60 * 60 * 1000);
        
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
