
package com.portfoliobackend.mfs.Servicio;

import com.portfoliobackend.mfs.Entidad.Experiencia;
import com.portfoliobackend.mfs.Repositorio.IExperienciaRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaServicio {  
    private final IExperienciaRepositorio iexperienciaRepositorio;
    
    @Autowired
    public ExperienciaServicio(IExperienciaRepositorio iexperienciaRepositorio){
        this.iexperienciaRepositorio = iexperienciaRepositorio;
    }
    
    public Experiencia agregarExperiencia(Experiencia experiencia){
        return iexperienciaRepositorio.save(experiencia);
    }
    
    
    public List<Experiencia> buscarExperiencias(){
        return iexperienciaRepositorio.findAll();
    }
    
    public Experiencia editarExperiencia(Experiencia experiencia){
        return iexperienciaRepositorio.save(experiencia);
    }
    
    public void borrarExperiencia(Long id){
        iexperienciaRepositorio.deleteById(id);
    }
    
}
