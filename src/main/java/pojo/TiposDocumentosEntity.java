package pojo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipos_documentos", schema = "pb_hotel_aristo_v1", catalog = "")
public class TiposDocumentosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;
    @Basic
    @Column(name = "nombre_tipo_documento")
    private String nombreTipoDocumento;

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiposDocumentosEntity that = (TiposDocumentosEntity) o;
        return idTipoDocumento == that.idTipoDocumento && Objects.equals(nombreTipoDocumento, that.nombreTipoDocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoDocumento, nombreTipoDocumento);
    }
}
