package com.portfoliobackend.mfs.Seguridad.Repositorio;

import com.portfoliobackend.mfs.Seguridad.Entidad.Rol;
import com.portfoliobackend.mfs.Seguridad.Enumeraciones.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepositorio extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
