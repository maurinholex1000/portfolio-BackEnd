package com.portfoliobackend.mfs.Interfaz;

import com.portfoliobackend.mfs.Entidad.Persona;
import java.util.List;

public interface IPersonaServicio {
    //Treaer persona
    public List<Persona> getPersona();
    
    //Guardar objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Elimnar objeto por ID
    public void deletePersona(Long id);
    
    //Buscar persona por ID
    public Persona findPersona(Long id);
    
}
