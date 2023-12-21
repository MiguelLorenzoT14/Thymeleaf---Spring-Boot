package com.consumidor.wed.service.Imp;

import com.consumidor.wed.client.PersonaClient;
import com.consumidor.wed.model.Persona;
import com.consumidor.wed.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    protected PersonaClient personaClient;
    @Override
    public List<Persona> ListarPersona() {
        return personaClient.listarPersona();
    }

    @Override
    public Persona AgregarPersona(Persona persona) {
        return personaClient.agregarPersona(persona);
    }

    @Override
    public Persona BuscarPersonaID(int id) {
        return  personaClient.buscarPersonaID(id);
    }

    @Override
    public void EliminarPersona(int id) {
        personaClient.eliminarPersona(id);
    }

}
