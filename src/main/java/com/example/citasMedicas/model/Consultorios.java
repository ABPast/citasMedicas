package com.example.citasMedicas.model;

import javax.persistence.*;

@Entity
@Table(name = "consultorios")
public class Consultorios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numero;

    private Integer piso;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Consultorios{" +
                "id=" + id +
                ", numero=" + numero +
                ", piso=" + piso +
                ", status=" + status +
                '}';
    }
}
