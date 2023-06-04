package pojo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "reservas", schema = "pb_hotel_aristo_v1", catalog = "")
public class ReservasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_reserva")
    private int idReserva;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    @Basic
    @Column(name = "fecha_reserva")
    private Date fechaReserva;

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Basic
    @Column(name = "valor_reserva")
    private double valorReserva;

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }

    @Basic
    @Column(name = "id_empresa")
    private int idEmpresa;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "id_persona_huesped")
    private int idPersonaHuesped;

    public int getIdPersonaHuesped() {
        return idPersonaHuesped;
    }

    public void setIdPersonaHuesped(int idPersonaHuesped) {
        this.idPersonaHuesped = idPersonaHuesped;
    }

    @Basic
    @Column(name = "id_tipo_acomodacion")
    private int idTipoAcomodacion;

    public int getIdTipoAcomodacion() {
        return idTipoAcomodacion;
    }

    public void setIdTipoAcomodacion(int idTipoAcomodacion) {
        this.idTipoAcomodacion = idTipoAcomodacion;
    }

    @Basic
    @Column(name = "id_persona_recepcionista")
    private int idPersonaRecepcionista;

    public int getIdPersonaRecepcionista() {
        return idPersonaRecepcionista;
    }

    public void setIdPersonaRecepcionista(int idPersonaRecepcionista) {
        this.idPersonaRecepcionista = idPersonaRecepcionista;
    }

    @Basic
    @Column(name = "observaciones_huesped_hotel")
    private String observacionesHuespedHotel;

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
}
