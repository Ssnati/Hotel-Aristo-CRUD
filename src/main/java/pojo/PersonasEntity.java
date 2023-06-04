package pojo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "personas", schema = "pb_hotel_aristo_v1", catalog = "")
public class PersonasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_persona")
    private int idPersona;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Basic
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Basic
    @Column(name = "id_lugar_expedicion_documento")
    private int idLugarExpedicionDocumento;

    public int getIdLugarExpedicionDocumento() {
        return idLugarExpedicionDocumento;
    }

    public void setIdLugarExpedicionDocumento(int idLugarExpedicionDocumento) {
        this.idLugarExpedicionDocumento = idLugarExpedicionDocumento;
    }

    @Basic
    @Column(name = "id_lugar_nacimiento")
    private int idLugarNacimiento;

    public int getIdLugarNacimiento() {
        return idLugarNacimiento;
    }

    public void setIdLugarNacimiento(int idLugarNacimiento) {
        this.idLugarNacimiento = idLugarNacimiento;
    }

    @Basic
    @Column(name = "nombre_persona")
    private String nombrePersona;

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @Basic
    @Column(name = "numero_telefono")
    private String numeroTelefono;

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Basic
    @Column(name = "numero_documento")
    private int numeroDocumento;

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Basic
    @Column(name = "fecha_expedicion_documento")
    private Date fechaExpedicionDocumento;

    public Date getFechaExpedicionDocumento() {
        return fechaExpedicionDocumento;
    }

    public void setFechaExpedicionDocumento(Date fechaExpedicionDocumento) {
        this.fechaExpedicionDocumento = fechaExpedicionDocumento;
    }

    @Basic
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonasEntity that = (PersonasEntity) o;
        return idPersona == that.idPersona && idTipoDocumento == that.idTipoDocumento && idLugarExpedicionDocumento == that.idLugarExpedicionDocumento && idLugarNacimiento == that.idLugarNacimiento && numeroDocumento == that.numeroDocumento && Objects.equals(nombrePersona, that.nombrePersona) && Objects.equals(numeroTelefono, that.numeroTelefono) && Objects.equals(fechaExpedicionDocumento, that.fechaExpedicionDocumento) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, idTipoDocumento, idLugarExpedicionDocumento, idLugarNacimiento, nombrePersona, numeroTelefono, numeroDocumento, fechaExpedicionDocumento, fechaNacimiento);
    }
}
