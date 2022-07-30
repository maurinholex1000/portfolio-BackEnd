
 package com.portfoliobackend.mfs.Repositorio;

import com.portfoliobackend.mfs.Entidad.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface IEducacionRepositorio extends JpaRepository<Educacion, Long> {
    
}
