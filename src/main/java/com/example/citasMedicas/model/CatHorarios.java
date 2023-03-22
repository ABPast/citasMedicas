package com.example.citasMedicas.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "cat_horarios")
public class CatHorarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcatHorarios;

    private Time hora;

    private Integer status;

    public Integer getIdcatHorarios() {
        return idcatHorarios;
    }

    public void setIdcatHorarios(Integer idcatHorarios) {
        this.idcatHorarios = idcatHorarios;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CatHorarios{" +
                "idcatHorarios=" + idcatHorarios +
                ", hora=" + hora +
                ", status=" + status +
                '}';
    }
}
