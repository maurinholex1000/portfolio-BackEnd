package com.portfoliobackend.mfs.Seguridad.Servicio;

import com.portfoliobackend.mfs.Seguridad.Entidad.Rol;
import com.portfoliobackend.mfs.Seguridad.Enumeraciones.RolNombre;
import com.portfoliobackend.mfs.Seguridad.Repositorio.iRolRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    @Autowired
    iRolRepositorio irolRepository;
    
    public Optional<Rol>getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
      
}
