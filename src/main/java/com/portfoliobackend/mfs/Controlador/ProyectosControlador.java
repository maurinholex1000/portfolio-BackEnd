package com.portfoliobackend.mfs.Controlador;

import com.portfoliobackend.mfs.Entidad.Proyectos;
import com.portfoliobackend.mfs.Servicio.ProyectosServicio;
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
@RequestMapping("/proyectos")
@CrossOrigin
public class ProyectosControlador {
    private final ProyectosServicio proyectosServicio;

    public ProyectosControlador(ProyectosServicio proyectosServicio) {
        this.proyectosServicio = proyectosServicio;
    }
    
    @PutMapping("/update")
    public ResponseEntity<Proyectos> editarExperiencia(@RequestBody Proyectos proyecto){
        Proyectos updateProyecto=proyectosServicio.editarProyecto(proyecto);
        return new ResponseEntity<>(updateProyecto,HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List <Proyectos>> obtenerProyecto(){
        List<Proyectos> proyectos=proyectosServicio.buscarProyectos();
        return new ResponseEntity<>(proyectos,HttpStatus.OK);
    }
      
    @PostMapping("/add")
    public ResponseEntity<Proyectos> crearProyecto(@RequestBody Proyectos skill){
        Proyectos nuevoProyecto=proyectosServicio.agregarProyecto(skill);
        return new ResponseEntity<>(nuevoProyecto,HttpStatus.CREATED);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("id") Long id){
        proyectosServicio.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
