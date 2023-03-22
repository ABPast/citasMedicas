package com.example.citasMedicas.endpoint;

import com.example.citasMedicas.model.Citas;
import com.example.citasMedicas.service.CitasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitasEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(CitasEndpoint.class);
    @Autowired
    private CitasService citasService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Citas citas){
        boolean islimit = citasService.citasLimit(citas.getIdMedico().getId(),citas.getFecha());
        if (islimit){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            LOG.info(">>>>> insert()-> citas: {}",citas);
            try{
                citasService.insertCitas(citas);
                return new ResponseEntity<>( HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
    @GetMapping()
    public ResponseEntity<Object> getCitas(){
        List<Citas> citasList = citasService.getCitas();
        return new ResponseEntity<>(citasList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam("id") int id, @RequestBody Citas citas) throws Exception {
        try {
            citasService.updateCitas(citas);
            return new ResponseEntity<>("Cita actualizado correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCitas(@PathVariable("id") int id) throws Exception{
        try {
            citasService.deleteCitas(id);
            return new ResponseEntity<>("Cita eliminado correctamente", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
