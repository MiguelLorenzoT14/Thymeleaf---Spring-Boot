package com.consumidor.wed.service;

import com.consumidor.wed.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> ListarPersona();
    Persona AgregarPersona(Persona persona);
    Persona BuscarPersonaID(int id);

    void EliminarPersona(int id);
}
