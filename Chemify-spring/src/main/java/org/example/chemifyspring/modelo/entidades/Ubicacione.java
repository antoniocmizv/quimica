package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ubicaciones", schema = "proyecto_quimica")
public class Ubicacione {
    @Id
    @Column(name = "Id_Ubicacion", nullable = false)
    private Integer id;

    @Column(name = "Nombre_Ubicacion", nullable = false, length = 100)
    private String nombreUbicacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Codigo_Almacen", nullable = false)
    private Sala codigoAlmacen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }

    public Sala getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(Sala codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

}