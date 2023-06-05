package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "empresas", schema = "pb_hotel_aristo_v1", catalog = "")
public class EmpresasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_empresa")
    private int idEmpresa;
    @Basic
    @Column(name = "nit_empresa")
    private int nitEmpresa;
    @Basic
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic
    @Column(name = "telefono_empresa")
    private String telefonoEmpresa;
    @Basic
    @Column(name = "correo_empresa")
    private String correoEmpresa;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresasEntity that = (EmpresasEntity) o;
        return idEmpresa == that.idEmpresa && nitEmpresa == that.nitEmpresa && Objects.equals(nombreEmpresa, that.nombreEmpresa) && Objects.equals(telefonoEmpresa, that.telefonoEmpresa) && Objects.equals(correoEmpresa, that.correoEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nitEmpresa, nombreEmpresa, telefonoEmpresa, correoEmpresa);
    }

    @Override
    public String toString() {
        return "EmpresasEntity{" +
                "idEmpresa=" + idEmpresa +
                ", nitEmpresa=" + nitEmpresa +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", telefonoEmpresa='" + telefonoEmpresa + '\'' +
                ", correoEmpresa='" + correoEmpresa + '\'' +
                '}';
    }
}
