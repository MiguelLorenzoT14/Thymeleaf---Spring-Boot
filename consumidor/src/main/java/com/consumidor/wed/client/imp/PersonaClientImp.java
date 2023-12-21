package com.consumidor.wed.client.imp;

import com.consumidor.wed.client.PersonaClient;
import com.consumidor.wed.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class PersonaClientImp implements PersonaClient {

    private RestTemplate restTemplate;
    private  String baseUrl = "http://localhost:8080/persona";


    @Override
    public List<Persona> listarPersona() {
        restTemplate = new RestTemplate();
        ResponseEntity<?> responseEntity = restTemplate.getForEntity(baseUrl, Persona[].class);
        Persona[] personas = (Persona[]) responseEntity.getBody();
        List<Persona> personasList = Arrays.asList(personas);
        return personasList;
    }

    @Override
    public Persona agregarPersona(Persona persona) {
        restTemplate = new RestTemplate();
        ResponseEntity<Persona> responseEntity = restTemplate.postForEntity(baseUrl, persona, Persona.class);
        return responseEntity.getBody();
    }

    @Override
    public Persona buscarPersonaID(int id) {
        restTemplate = new RestTemplate();
        String url = baseUrl + "/" + id;
        ResponseEntity<Persona> responseEntity = restTemplate.getForEntity(url, Persona.class);
        return responseEntity.getBody();
    }

    @Override
    public void eliminarPersona(int id) {
        restTemplate = new RestTemplate();
        String url = baseUrl + "/" + id;
        restTemplate.delete(url);
    }



}
