package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "servicios_usados", schema = "pb_hotel_aristo_v1", catalog = "")
@IdClass(pojo.ServiciosUsadosEntityPK.class)
public class ServiciosUsadosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_servicio")
    private int idServicio;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

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
    @Column(name = "precio_servicio")
    private int precioServicio;

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
