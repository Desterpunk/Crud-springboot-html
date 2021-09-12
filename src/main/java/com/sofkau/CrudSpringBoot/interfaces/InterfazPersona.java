package com.sofkau.CrudSpringBoot.interfaces;

import com.sofkau.CrudSpringBoot.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazPersona extends CrudRepository<Persona, Integer> {
}
