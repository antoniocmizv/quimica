package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "materiales", schema = "proyecto_quimica")
public class Materiale {
    @Id
    @Column(name = "Id_Material", nullable = false)
    private Integer id;

    @Column(name = "Subtipo", nullable = false, length = 50)
    private String subtipo;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "Fecha_Compra", nullable = false, length = 30)
    private String fechaCompra;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_Producto", nullable = false)
    private Producto idProducto;

    @Column(name = "N_Serie", length = 50)
    private String nSerie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String nSerie) {
        this.nSerie = nSerie;
    }

}