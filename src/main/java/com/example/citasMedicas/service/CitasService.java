package com.example.citasMedicas.service;

import com.example.citasMedicas.model.Citas;

import java.util.Date;
import java.util.List;

public interface CitasService {

    Citas insertCitas(Citas citas);

    void updateCitas(Citas citas);

    List<Citas> getCitas();

    void deleteCitas(int id) throws Exception;

    boolean citasLimit(int id, Date fecha);
}
