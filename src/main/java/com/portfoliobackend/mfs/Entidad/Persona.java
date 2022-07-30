package com.portfoliobackend.mfs.Entidad;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    
    private String titulo;
    private String despcripcion;
    private String portada;
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String img;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Experiencia> experienciaList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Skills> skillList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Proyectos> proyectoList;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, String despcripcion,String portada, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.despcripcion = despcripcion;
        this.portada=portada;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDespcripcion() {
        return despcripcion;
    }

    public void setDespcripcion(String despcripcion) {
        this.despcripcion = despcripcion;
    }
    
    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    public List<Skills> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skills> skillList) {
        this.skillList = skillList;
    }
    
     public List<Proyectos> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyectos> proyectoList) {
            this.proyectoList = proyectoList;
    }
    
    
   
    
    
    
}
