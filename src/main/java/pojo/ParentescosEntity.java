package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "parentescos", schema = "pb_hotel_aristo_v1", catalog = "")
public class ParentescosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_parentesco")
    private int idParentesco;
    @Basic
    @Column(name = "nombre_parentesco")
    private String nombreParentesco;

    public int getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(int idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getNombreParentesco() {
        return nombreParentesco;
    }

    public void setNombreParentesco(String nombreParentesco) {
        this.nombreParentesco = nombreParentesco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentescosEntity that = (ParentescosEntity) o;
        return idParentesco == that.idParentesco && Objects.equals(nombreParentesco, that.nombreParentesco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParentesco, nombreParentesco);
    }
}
