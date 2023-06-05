package pojo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservas", schema = "pb_hotel_aristo_v1", catalog = "")
public class ReservasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserva")
    private int idReserva;
    @Basic
    @Column(name = "fecha_reserva")
    private Date fechaReserva;
    @Basic
    @Column(name = "valor_reserva")
    private double valorReserva;
    @Basic
    @Column(name = "id_empresa")
    private int idEmpresa;
    @Basic
    @Column(name = "id_persona_huesped")
    private int idPersonaHuesped;
    @Basic
    @Column(name = "id_tipo_acomodacion")
    private int idTipoAcomodacion;
    @Basic
    @Column(name = "id_persona_recepcionista")
    private int idPersonaRecepcionista;
    @Basic
    @Column(name = "observaciones_huesped_hotel")
    private String observacionesHuespedHotel;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdPersonaHuesped() {
        return idPersonaHuesped;
    }

    public void setIdPersonaHuesped(int idPersonaHuesped) {
        this.idPersonaHuesped = idPersonaHuesped;
    }

    public int getIdTipoAcomodacion() {
        return idTipoAcomodacion;
    }

    public void setIdTipoAcomodacion(int idTipoAcomodacion) {
        this.idTipoAcomodacion = idTipoAcomodacion;
    }

    public int getIdPersonaRecepcionista() {
        return idPersonaRecepcionista;
    }

    public void setIdPersonaRecepcionista(int idPersonaRecepcionista) {
        this.idPersonaRecepcionista = idPersonaRecepcionista;
    }

    public String getObservacionesHuespedHotel() {
        return observacionesHuespedHotel;
    }

    public void setObservacionesHuespedHotel(String observacionesHuespedHotel) {
        this.observacionesHuespedHotel = observacionesHuespedHotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservasEntity that = (ReservasEntity) o;
        return idReserva == that.idReserva && Double.compare(that.valorReserva, valorReserva) == 0 && idEmpresa == that.idEmpresa && idPersonaHuesped == that.idPersonaHuesped && idTipoAcomodacion == that.idTipoAcomodacion && idPersonaRecepcionista == that.idPersonaRecepcionista && Objects.equals(fechaReserva, that.fechaReserva) && Objects.equals(observacionesHuespedHotel, that.observacionesHuespedHotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, fechaReserva, valorReserva, idEmpresa, idPersonaHuesped, idTipoAcomodacion, idPersonaRecepcionista, observacionesHuespedHotel);
    }

    @Override
    public String toString() {
        return "ReservasEntity{" +
                "idReserva=" + idReserva +
                ", fechaReserva=" + fechaReserva +
                ", valorReserva=" + valorReserva +
                ", idEmpresa=" + idEmpresa +
                ", idPersonaHuesped=" + idPersonaHuesped +
                ", idTipoAcomodacion=" + idTipoAcomodacion +
                ", idPersonaRecepcionista=" + idPersonaRecepcionista +
                ", observacionesHuespedHotel='" + observacionesHuespedHotel + '\'' +
                '}';
    }
}
