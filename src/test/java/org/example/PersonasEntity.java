package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "personas", schema = "pb_hotel_aristo_v1", catalog = "")
public class PersonasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_persona")
    private int idPersona;
    @Basic
    @Column(name = "numero_documento")
    private int numeroDocumento;
    @Basic
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;
    @Basic
    @Column(name = "id_lugar")
    private int idLugar;
    @Basic
    @Column(name = "nombre_persona")
    private String nombrePersona;
    @Basic
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @Basic
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Basic
    @Column(name = "id_contacto_emergencia")
    private int idContactoEmergencia;
    @Basic
    @Column(name = "numero_emergencia")
    private int numeroEmergencia;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdContactoEmergencia() {
        return idContactoEmergencia;
    }

    public void setIdContactoEmergencia(int idContactoEmergencia) {
        this.idContactoEmergencia = idContactoEmergencia;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonasEntity that = (PersonasEntity) o;

        if (idPersona != that.idPersona) return false;
        if (numeroDocumento != that.numeroDocumento) return false;
        if (idTipoDocumento != that.idTipoDocumento) return false;
        if (idLugar != that.idLugar) return false;
        if (idContactoEmergencia != that.idContactoEmergencia) return false;
        if (numeroEmergencia != that.numeroEmergencia) return false;
        if (nombrePersona != null ? !nombrePersona.equals(that.nombrePersona) : that.nombrePersona != null)
            return false;
        if (numeroTelefono != null ? !numeroTelefono.equals(that.numeroTelefono) : that.numeroTelefono != null)
            return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersona;
        result = 31 * result + numeroDocumento;
        result = 31 * result + idTipoDocumento;
        result = 31 * result + idLugar;
        result = 31 * result + (nombrePersona != null ? nombrePersona.hashCode() : 0);
        result = 31 * result + (numeroTelefono != null ? numeroTelefono.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + idContactoEmergencia;
        result = 31 * result + numeroEmergencia;
        return result;
    }
}
