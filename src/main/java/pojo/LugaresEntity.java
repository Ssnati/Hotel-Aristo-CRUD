package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "lugares", schema = "pb_hotel_aristo_v1", catalog = "")
public class LugaresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_lugar")
    private int idLugar;

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    @Basic
    @Column(name = "nombre_lugar")
    private String nombreLugar;

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    @Basic
    @Column(name = "tipo_lugar")
    private String tipoLugar;

    public String getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(String tipoLugar) {
        this.tipoLugar = tipoLugar;
    }

    @Basic
    @Column(name = "id_lugar_ubicacion")
    private Integer idLugarUbicacion;

    public Integer getIdLugarUbicacion() {
        return idLugarUbicacion;
    }

    public void setIdLugarUbicacion(Integer idLugarUbicacion) {
        this.idLugarUbicacion = idLugarUbicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LugaresEntity that = (LugaresEntity) o;
        return idLugar == that.idLugar && Objects.equals(nombreLugar, that.nombreLugar) && Objects.equals(tipoLugar, that.tipoLugar) && Objects.equals(idLugarUbicacion, that.idLugarUbicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLugar, nombreLugar, tipoLugar, idLugarUbicacion);
    }
}
