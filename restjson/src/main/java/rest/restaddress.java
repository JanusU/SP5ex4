/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import data.dataGenerator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author JanusPC
 */
@Path("addresses")
public class restaddress {

    dataGenerator dtg = new dataGenerator();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of restaddress
     */
    public restaddress() {
    }

    /**
     * Retrieves representation of an instance of rest.restaddress
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/adresses/{ammount : \\d+}/{output}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSON(
            @PathParam("ammount") int ammount,
            @PathParam("output") String output) {
        
        String json = dtg.getData(ammount, output);
        
        return Response.status(Response.Status.OK)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of restaddress
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJSON(String content) {
    }
}
