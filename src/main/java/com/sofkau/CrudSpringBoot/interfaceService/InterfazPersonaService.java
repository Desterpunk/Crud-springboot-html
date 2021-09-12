package com.sofkau.CrudSpringBoot.interfaceService;

import com.sofkau.CrudSpringBoot.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface InterfazPersonaService {
    public List<Persona> listar();
    public Optional<Persona>listarId(int id);
    public int save(Persona persona);
    public void delete(int id);
}
