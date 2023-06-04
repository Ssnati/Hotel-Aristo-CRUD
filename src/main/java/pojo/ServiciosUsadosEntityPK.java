package pojo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ServiciosUsadosEntityPK implements Serializable {
    @Column(name = "id_servicio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    @Column(name = "id_reserva")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciosUsadosEntityPK that = (ServiciosUsadosEntityPK) o;
        return idServicio == that.idServicio && idReserva == that.idReserva;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, idReserva);
    }
}
