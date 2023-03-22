package com.example.citasMedicas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
@NamedQueries({
        @NamedQuery(name = "Citas.getMedicoCitasDay", query = "select c from Citas c where c.status= 1 and c.idMedico.id = :id and c.fecha = :date"),
        @NamedQuery(name = "Citas.getMedicoCitas", query = "select c from Citas c where c.status= 1 and c.idMedico.id = :id"),
        @NamedQuery(name = "Citas.getCitasDay", query = "select c from Citas c where c.status= 1 and c.fecha = :date")
})
public class Citas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCitas;

    @ManyToOne
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id")
    private Consultorios idConsultorio;
    @ManyToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id")
    private Medicos idMedico;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_cathorario", referencedColumnName = "idcatHorarios")
    private CatHorarios idCathorario;

    private String nomPaciente;

    private Integer estado;

    private Integer status;

    public Integer getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(Integer idCitas) {
        this.idCitas = idCitas;
    }

    public Consultorios getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Consultorios idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Medicos getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medicos idMedico) {
        this.idMedico = idMedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CatHorarios getIdCathorario() {
        return idCathorario;
    }

    public void setIdCathorario(CatHorarios idCathorario) {
        this.idCathorario = idCathorario;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Citas{" +
                "idCitas=" + idCitas +
                ", idConsultorio=" + idConsultorio +
                ", idMedico=" + idMedico +
                ", fecha=" + fecha +
                ", idCathorario=" + idCathorario +
                ", nomPaciente='" + nomPaciente + '\'' +
                ", estado=" + estado +
                ", status=" + status +
                '}';
    }
}
