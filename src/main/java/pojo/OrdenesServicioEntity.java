package pojo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ordenes_servicio", schema = "pb_hotel_aristo_v1", catalog = "")
public class OrdenesServicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero_orden")
    private int numeroOrden;
    @Basic
    @Column(name = "id_reserva")
    private int idReserva;
    @Basic
    @Column(name = "fecha_orden")
    private Date fechaOrden;

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdenesServicioEntity that = (OrdenesServicioEntity) o;
        return numeroOrden == that.numeroOrden && idReserva == that.idReserva && Objects.equals(fechaOrden, that.fechaOrden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroOrden, idReserva, fechaOrden);
    }
}
