package com.portfoliobackend.mfs.Controlador;

import com.portfoliobackend.mfs.Entidad.Skills;
import com.portfoliobackend.mfs.Servicio.SkillsServicio;
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
@RequestMapping("/skills")
@CrossOrigin(origins ="http://localhost:4200")
public class SkillsControlador {
      private final SkillsServicio skillsServicio;

    public SkillsControlador(SkillsServicio skillsServicio) {
        this.skillsServicio = skillsServicio;
    }
    
    @PutMapping("/update")
    public ResponseEntity<Skills> editarSkill(@RequestBody Skills skill){
        Skills updateSkill=skillsServicio.editarSkill(skill);
        return new ResponseEntity<>(updateSkill,HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List <Skills>> obtenerEducacion(){
        List<Skills> educaciones=skillsServicio.buscarSkills();
        return new ResponseEntity<>(educaciones,HttpStatus.OK);
    }
      
    @PostMapping("/add")
    public ResponseEntity<Skills> crearSkill(@RequestBody Skills skill){
        Skills nuevoSkill=skillsServicio.agregarSkill(skill);
        return new ResponseEntity<>(nuevoSkill,HttpStatus.CREATED);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
        skillsServicio.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
