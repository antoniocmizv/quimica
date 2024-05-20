package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formato", schema = "proyecto_quimica")
public class Formato {
    @Id
    @Column(name = "Id_Formato", nullable = false)
    private Integer id;

    @Column(name = "Formato", nullable = false, length = 20)
    private String formato;

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

}