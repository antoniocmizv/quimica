package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salas", schema = "proyecto_quimica")
public class Sala {
    @Id
    @Column(name = "Id_Almacen", nullable = false)
    private Integer id;

    @Column(name = "Nombre_Almacen", nullable = false, length = 50)
    private String nombreAlmacen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

}