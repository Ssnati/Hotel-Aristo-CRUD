package pojo;

import java.sql.Date;

public class ReserveFullData {
    private int idReserve;
    private Date reserveDate;
    private double reserveValue;
    private String bookingCompanyName;
    private String guestName;
    private String acomodateTypeName;
    private String receptionistName;
    private String reserveObservations;

    public ReserveFullData() {
        idReserve = 0;
        reserveDate = new Date(0);
        reserveValue = 0;
        bookingCompanyName = "";
        guestName = "";
        acomodateTypeName = "";
        receptionistName = "";
        reserveObservations = "";
    }

    public int getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public double getReserveValue() {
        return reserveValue;
    }

    public void setReserveValue(double reserveValue) {
        this.reserveValue = reserveValue;
    }

    public String getBookingCompanyName() {
        return bookingCompanyName;
    }

    public void setBookingCompanyName(String bookingCompanyName) {
        this.bookingCompanyName = bookingCompanyName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getAcomodateTypeName() {
        return acomodateTypeName;
    }

    public void setAcomodateTypeName(String acomodateTypeName) {
        this.acomodateTypeName = acomodateTypeName;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public void setReceptionistName(String receptionistName) {
        this.receptionistName = receptionistName;
    }

    public String getReserveObservations() {
        return reserveObservations;
    }

    public void setReserveObservations(String reserveObservations) {
        this.reserveObservations = reserveObservations;
    }

    @Override
    public String toString() {
        return "ReserveFullData{" +
                "idReserve=" + idReserve +
                ", reserveDate=" + reserveDate +
                ", reserveValue=" + reserveValue +
                ", bookingCompanyName='" + bookingCompanyName + '\'' +
                ", guestName='" + guestName + '\'' +
                ", acomodateTypeName='" + acomodateTypeName + '\'' +
                ", receptionistName='" + receptionistName + '\'' +
                ", reserveObservations='" + reserveObservations + '\'' +
                '}';
    }
}