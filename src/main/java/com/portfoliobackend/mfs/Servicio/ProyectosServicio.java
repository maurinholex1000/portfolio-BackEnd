package com.portfoliobackend.mfs.Servicio;

import com.portfoliobackend.mfs.Entidad.Proyectos;
import com.portfoliobackend.mfs.Repositorio.IProyectosRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosServicio {
    private final IProyectosRepositorio iproyectosRepositorio;
    
    @Autowired
    public ProyectosServicio(IProyectosRepositorio iproyectosRepositorio){
        this.iproyectosRepositorio = iproyectosRepositorio;
    }
    
    public Proyectos agregarProyecto(Proyectos proyectos){
        return iproyectosRepositorio.save(proyectos);
    }
    
    
    public List<Proyectos> buscarProyectos(){
        return iproyectosRepositorio.findAll();
    }
    
    public Proyectos editarProyecto(Proyectos proyectos){
        return iproyectosRepositorio.save(proyectos);
    }
    
    public void borrarProyecto(Long id){
        iproyectosRepositorio.deleteById(id);
    }
    
}
