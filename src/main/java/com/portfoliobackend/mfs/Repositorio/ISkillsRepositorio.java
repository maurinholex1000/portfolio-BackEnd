
package com.portfoliobackend.mfs.Repositorio;
import com.portfoliobackend.mfs.Entidad.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepositorio extends JpaRepository<Skills, Long>{
    
}
