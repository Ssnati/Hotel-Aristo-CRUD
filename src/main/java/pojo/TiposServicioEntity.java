package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipos_servicio", schema = "pb_hotel_aristo_v1", catalog = "")
public class TiposServicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_servicio")
    private int idTipoServicio;
    @Basic
    @Column(name = "nombre_tipo_servicio")
    private String nombreTipoServicio;
    @Basic
    @Column(name = "precio_servicio")
    private double precioServicio;

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiposServicioEntity that = (TiposServicioEntity) o;
        return idTipoServicio == that.idTipoServicio && Double.compare(that.precioServicio, precioServicio) == 0 && Objects.equals(nombreTipoServicio, that.nombreTipoServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoServicio, nombreTipoServicio, precioServicio);
    }
}
