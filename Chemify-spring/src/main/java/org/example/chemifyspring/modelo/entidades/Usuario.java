package org.example.chemifyspring.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "proyecto_quimica")
public class Usuario {
    @Id
    @Column(name = "username", nullable = false, length = 10)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}