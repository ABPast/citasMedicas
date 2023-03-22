package com.example.citasMedicas.service.serviceImpl;

import com.example.citasMedicas.model.Citas;
import com.example.citasMedicas.repository.CitasRepository;
import com.example.citasMedicas.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitasServiceImpl implements CitasService {
    @Autowired
    private CitasRepository citasRepository;

    @Override
    public Citas insertCitas(Citas citas) {
        return citasRepository.save(citas);
    }
    @Override
    public List<Citas> getCitas(){
        return (List<Citas>) citasRepository.findAll();
    }

    @Override
    public void updateCitas(Citas citas){
        citasRepository.save(citas);
    }

    @Override
    public void deleteCitas(int id) throws Exception{
        try {
            Optional<Citas> citas = citasRepository.findById(id);
            if(citas == null){
                throw new Exception("No se encuentra la cita");
            } if (citas.get().getStatus() == 0){
                throw new Exception("No existe el registro");
            }
            citas.get().setStatus(0);
            citasRepository.save(citas.get());
        } catch (Exception e){
            throw new Exception("Error al eliminar");
        }
    }

    @Override
    public boolean citasLimit(int id, Date fecha){
        int limit;
        limit = citasRepository.getMedicoCitasDay(id,fecha).size();
        return limit > 8;
    }

}
