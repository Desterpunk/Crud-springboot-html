package com.sofkau.CrudSpringBoot.service;

import com.sofkau.CrudSpringBoot.interfaceService.InterfazPersonaService;
import com.sofkau.CrudSpringBoot.interfaces.InterfazPersona;
import com.sofkau.CrudSpringBoot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements InterfazPersonaService {
    @Autowired
    private InterfazPersona data;
    @Override
    public List<Persona> listar() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Persona persona) {
        int respuesta = 0;
        Persona persona1 = data.save(persona);
        if (!persona.equals(null)){
            respuesta=1;
        }
        return respuesta;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
