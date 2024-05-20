package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "productos_auxiliares", schema = "proyecto_quimica")
public class ProductosAuxiliare {
    @Id
    @Column(name = "Id_Producto_Auxiliar", nullable = false)
    private Integer id;

    @Column(name = "Formato", nullable = false, length = 50)
    private String formato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_Producto", nullable = false)
    private Producto idProducto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

}