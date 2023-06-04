package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipos_acomodacion", schema = "pb_hotel_aristo_v1", catalog = "")
public class TiposAcomodacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_acomodacion")
    private int idTipoAcomodacion;
    @Basic
    @Column(name = "nombre_tipo_acomodacion")
    private String nombreTipoAcomodacion;
    @Basic
    @Column(name = "precio_acomodacion")
    private double precioAcomodacion;

    public int getIdTipoAcomodacion() {
        return idTipoAcomodacion;
    }

    public void setIdTipoAcomodacion(int idTipoAcomodacion) {
        this.idTipoAcomodacion = idTipoAcomodacion;
    }

    public String getNombreTipoAcomodacion() {
        return nombreTipoAcomodacion;
    }

    public void setNombreTipoAcomodacion(String nombreTipoAcomodacion) {
        this.nombreTipoAcomodacion = nombreTipoAcomodacion;
    }

    public double getPrecioAcomodacion() {
        return precioAcomodacion;
    }

    public void setPrecioAcomodacion(double precioAcomodacion) {
        this.precioAcomodacion = precioAcomodacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiposAcomodacionEntity that = (TiposAcomodacionEntity) o;
        return idTipoAcomodacion == that.idTipoAcomodacion && Double.compare(that.precioAcomodacion, precioAcomodacion) == 0 && Objects.equals(nombreTipoAcomodacion, that.nombreTipoAcomodacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoAcomodacion, nombreTipoAcomodacion, precioAcomodacion);
    }
}
