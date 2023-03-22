package com.example.citasMedicas.repository;

import com.example.citasMedicas.model.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Integer> {
    List<Citas> getMedicoCitasDay(int id, Date date);
}
