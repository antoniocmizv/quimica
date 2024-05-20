package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "correos", schema = "proyecto_quimica")
public class Correo {
    @Column(name = "destinatario", length = 150)
    private String destinatario;

    @Column(name = "nombre", length = 150)
    private String nombre;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}