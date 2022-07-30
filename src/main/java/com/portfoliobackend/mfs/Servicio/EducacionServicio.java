package com.portfoliobackend.mfs.Servicio;

import com.portfoliobackend.mfs.Entidad.Educacion;
import com.portfoliobackend.mfs.Repositorio.IEducacionRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionServicio {
    
    private final IEducacionRepositorio ieducacionRepositorio;
    
    @Autowired
    public EducacionServicio(IEducacionRepositorio ieducacionRepositorio){
        this.ieducacionRepositorio = ieducacionRepositorio;
    }
    
    public Educacion agregarEducacion(Educacion educacion){
        return ieducacionRepositorio.save(educacion);
    }
    
    
    public List<Educacion> buscarEducaciones(){
        return ieducacionRepositorio.findAll();
    }
    
    public Educacion editarEducacion(Educacion educacion){
        return ieducacionRepositorio.save(educacion);
    }
    
    public void borrarEducacion(Long id){
        ieducacionRepositorio.deleteById(id);
    }
    
    
}
