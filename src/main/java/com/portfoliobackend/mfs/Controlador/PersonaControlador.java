package com.portfoliobackend.mfs.Controlador;

import com.portfoliobackend.mfs.Entidad.Persona;
import com.portfoliobackend.mfs.Interfaz.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonaControlador{
    @Autowired IPersonaServicio ipersonaServicio;
    
    /*private final IPersonaServicio ipersonaServicio;

    public PersonaControlador(IPersonaServicio ipersonaServicio) {
        this.ipersonaServicio = ipersonaServicio;
    }*/
    
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaServicio.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaServicio.savePersona(persona);
        return "La persona fue creada con exito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaServicio.deletePersona(id);
        return "La persona fue eliminada con exito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestBody Persona persona){
        String nuevoNombre=persona.getNombre();
        String nuevoApellido=persona.getApellido();
        String nuevoTitulo=persona.getTitulo();
        String nuevoDespcripcion=persona.getDespcripcion();
        String nuevoPortada=persona.getPortada();
        String nuevoImg=persona.getImg();
        Persona personanueva=ipersonaServicio.findPersona(id);

        
        
        personanueva.setNombre(nuevoNombre);
        personanueva.setApellido(nuevoApellido);
        personanueva.setTitulo(nuevoTitulo);
        personanueva.setDespcripcion(nuevoDespcripcion);
        personanueva.setPortada(nuevoPortada);
        personanueva.setImg(nuevoImg);
        
        ipersonaServicio.savePersona(personanueva);
        return persona;
        
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaServicio.findPersona((long)1);
    }

}
