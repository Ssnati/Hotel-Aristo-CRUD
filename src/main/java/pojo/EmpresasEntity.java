package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "empresas", schema = "pb_hotel_aristo_v1", catalog = "")
public class EmpresasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_empresa")
    private int idEmpresa;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "nit_empresa")
    private int nitEmpresa;

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    @Basic
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Basic
    @Column(name = "telefono_empresa")
    private String telefonoEmpresa;

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    @Basic
    @Column(name = "correo_empresa")
    private String correoEmpresa;

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
}