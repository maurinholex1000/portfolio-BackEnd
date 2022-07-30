package com.portfoliobackend.mfs.Controlador;


import com.portfoliobackend.mfs.Entidad.Experiencia;
import com.portfoliobackend.mfs.Servicio.ExperienciaServicio;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaControlador {
    private final ExperienciaServicio experienciaServicio;

    public ExperienciaControlador(ExperienciaServicio experienciaServicio) {
        this.experienciaServicio = experienciaServicio;
    }
    
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){
        Experiencia updateExperiencia=experienciaServicio.editarExperiencia(experiencia);
        return new ResponseEntity<>(updateExperiencia,HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List <Experiencia>> obtenerExperiencia(){
        List<Experiencia> experiencias=experienciaServicio.buscarExperiencias();
        return new ResponseEntity<>(experiencias,HttpStatus.OK);
    }
      
    @PostMapping("/add")
    public ResponseEntity<Experiencia> crearEducacion(@RequestBody Experiencia experiencia){
        Experiencia nuevaExperiencia=experienciaServicio.agregarExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia,HttpStatus.CREATED);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("id") Long id){
        experienciaServicio.borrarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}