package com.demo.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.demo.model.Persona;
import com.demo.service.PersonaService;

/**
 * Session Bean implementation class PersonaBean
 */
@Named("personaBean")
@RequestScoped
public class PersonaBean {
	@Inject
	private PersonaService personaService;
	private Persona personaSeleccionada;
	List<Persona> personas;

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	/**
     * Default constructor. 
     */
    public PersonaBean() {
        System.out.println("Constructor PersonaBean");
    }
    @PostConstruct
    public void inicializarBean() {
        System.out.println("inicializarBean PersonaBean");
    	personas=personaService.findAll();
    	personaSeleccionada=new Persona();
    }
    
    public void editListener(RowEditEvent row) {
        System.out.println("editListener PersonaBean");
    	Persona persona=(Persona)row.getObject();
    	personaService.update(persona);
    }
    
    public void agregarPersona() {
    	personaService.insert(personaSeleccionada);
    	this.personas.add(personaSeleccionada);
    	this.personaSeleccionada=null;
    }
    public void eliminarPersona() {
    	personaService.delete(personaSeleccionada);
    	this.personas.remove(personaSeleccionada);
    	this.personaSeleccionada=null;
    }
    public void cleanPersonaSeleccionada() {
    	this.personaSeleccionada=new Persona();
    }
    
    public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}
	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}
	public List<Persona> getPersonas() {
		return personas;
	}

}
