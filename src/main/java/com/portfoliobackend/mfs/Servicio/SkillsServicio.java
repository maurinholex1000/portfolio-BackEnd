package com.portfoliobackend.mfs.Servicio;

import com.portfoliobackend.mfs.Entidad.Skills;
import com.portfoliobackend.mfs.Repositorio.ISkillsRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SkillsServicio {
    private final ISkillsRepositorio iskillsRepositorio;
    
    @Autowired
    public SkillsServicio(ISkillsRepositorio iskillsRepositorio){
        this.iskillsRepositorio = iskillsRepositorio;
    }
    
    public Skills agregarSkill(Skills skills){
        return iskillsRepositorio.save(skills);
    }
    
    
    public List<Skills> buscarSkills(){
        return iskillsRepositorio.findAll();
    }
    
    public Skills editarSkill(Skills skills){
        return iskillsRepositorio.save(skills);
    }
    
    public void borrarSkill(Long id){
        iskillsRepositorio.deleteById(id);
    }
    
}
