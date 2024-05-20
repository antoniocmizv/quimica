package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "quimicos", schema = "proyecto_quimica")
public class Quimico {
    @Id
    @Column(name = "Id_Quimico", nullable = false)
    private Integer id;

    @Column(name = "Pureza", nullable = false, length = 20)
    private String pureza;

    @Column(name = "Fecha_Caducidad", length = 20)
    private String fechaCaducidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_Producto", nullable = false)
    private Producto idProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_Formato", nullable = false)
    private Formato idFormato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPureza() {
        return pureza;
    }

    public void setPureza(String pureza) {
        this.pureza = pureza;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Formato getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Formato idFormato) {
        this.idFormato = idFormato;
    }

}