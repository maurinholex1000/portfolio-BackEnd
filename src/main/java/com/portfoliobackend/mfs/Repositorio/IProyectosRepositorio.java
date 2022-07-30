package com.portfoliobackend.mfs.Repositorio;

import com.portfoliobackend.mfs.Entidad.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepositorio extends JpaRepository<Proyectos, Long> {
    
}
