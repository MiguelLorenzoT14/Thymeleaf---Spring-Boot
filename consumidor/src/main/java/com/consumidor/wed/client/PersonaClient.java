package com.consumidor.wed.client;

import com.consumidor.wed.model.Persona;

import java.util.List;

public interface PersonaClient {

    List<Persona> listarPersona();
    Persona agregarPersona(Persona persona);
    Persona buscarPersonaID(int id);
    void eliminarPersona(int id);
}
