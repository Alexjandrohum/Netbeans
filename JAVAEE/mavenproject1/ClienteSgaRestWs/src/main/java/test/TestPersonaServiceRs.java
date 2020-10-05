/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 *
 * @author alexjandrohum
 */
public class TestPersonaServiceRs {

    //Variables a utilizar
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client client;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;

    public static void main(String[] args) {
        client = ClientBuilder.newClient();
        //leer una persona
        webTarget = client.target(URL_BASE).path("/personas");
        persona = webTarget.path("/3").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);

        //Leer todas las personas
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>() {
        });
        System.out.println("\n Personas recuperadas:");
        imprimirPersonas(personas);

        //Agrear una persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Juan");
        nuevaPersona.setApellido("Maqrquez");
        nuevaPersona.setEmail("sdad@sdaewr");
        nuevaPersona.setTelefono("453453");

        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Resuperamos a la persona recien agregada para modificarna y al final la vamos a eliminar
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: " + personaRecuperada);

        //Modificar la persona agregada(método put)
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("jauaua");
      
        String pathId = "/3";
        
        //invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        System.out.println("Persona modificada: "+response.readEntity(Persona.class));


        
        
        
        
    }

    private static void imprimirPersonas(List<Persona> personas) {
        for(Persona persona : personas){
            System.out.println("Persona: "+persona);
        }
    }
    
                                   }
