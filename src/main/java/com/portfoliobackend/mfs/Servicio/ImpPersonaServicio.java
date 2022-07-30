package com.portfoliobackend.mfs.Servicio;

import com.portfoliobackend.mfs.Entidad.Persona;
import com.portfoliobackend.mfs.Interfaz.IPersonaServicio;
import com.portfoliobackend.mfs.Repositorio.IPersonaRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
/*public class ImpPersonaServicio {*/
public class ImpPersonaServicio implements IPersonaServicio{
    @Autowired IPersonaRepositorio ipersonaRepositorio;
    
    /*private final IPersonaRepositorio ipersonaRepositorio;
    
    @Autowired
    public ImpPersonaServicio(IPersonaRepositorio ipersonaRepositorio){
        this.ipersonaRepositorio = ipersonaRepositorio;
    }*/
    
    @Override
    
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepositorio.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepositorio.deleteById(id);
    }
    
    /*@Override
    public Persona editPersona(Persona persona){
        return ipersonaRepositorio.save(persona);
    }*/

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepositorio.findById(id).orElse(null);
        return persona;
    }
    
   
    
}
