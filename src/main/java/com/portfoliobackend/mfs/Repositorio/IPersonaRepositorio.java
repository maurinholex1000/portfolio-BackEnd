package com.portfoliobackend.mfs.Repositorio;

import com.portfoliobackend.mfs.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona,Long>{
    
}
