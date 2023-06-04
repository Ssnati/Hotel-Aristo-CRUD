package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contactos_emergencia_huespedes", schema = "pb_hotel_aristo_v1", catalog = "")
public class ContactosEmergenciaHuespedesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contacto_emergencia")
    private int idContactoEmergencia;
    @Basic
    @Column(name = "id_persona")
    private int idPersona;
    @Basic
    @Column(name = "id_parentesco")
    private int idParentesco;
    @Basic
    @Column(name = "numero_emergencia")
    private String numeroEmergencia;

    public int getIdContactoEmergencia() {
        return idContactoEmergencia;
    }

    public void setIdContactoEmergencia(int idContactoEmergencia) {
        this.idContactoEmergencia = idContactoEmergencia;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(int idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactosEmergenciaHuespedesEntity that = (ContactosEmergenciaHuespedesEntity) o;
        return idContactoEmergencia == that.idContactoEmergencia && idPersona == that.idPersona && idParentesco == that.idParentesco && Objects.equals(numeroEmergencia, that.numeroEmergencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContactoEmergencia, idPersona, idParentesco, numeroEmergencia);
    }
}
