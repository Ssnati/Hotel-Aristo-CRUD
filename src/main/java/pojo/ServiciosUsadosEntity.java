package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "servicios_usados", schema = "pb_hotel_aristo_v1", catalog = "")
@IdClass(ServiciosUsadosEntityPK.class)
public class ServiciosUsadosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_servicio")
    private int idServicio;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserva")
    private int idReserva;
    @Basic
    @Column(name = "precio_servicio")
    private int precioServicio;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(int precioServicio) {
        this.precioServicio = precioServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciosUsadosEntity that = (ServiciosUsadosEntity) o;
        return idServicio == that.idServicio && idReserva == that.idReserva && precioServicio == that.precioServicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, idReserva, precioServicio);
    }
}
