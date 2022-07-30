package com.portfoliobackend.mfs.Repositorio;

import com.portfoliobackend.mfs.Entidad.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepositorio extends JpaRepository<Experiencia, Long>{

}
    
