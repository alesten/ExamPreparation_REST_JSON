/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.DataGenerator;

/**
 * REST Web Service
 *
 * @author AlexanderSteen
 */
@Path("addresses")
public class addressesResource {

    private final DataGenerator dataGenerator;
    
    @Context
    private UriInfo context;

    public addressesResource() {
        this.dataGenerator = new DataGenerator();
    }

    @GET
    @Produces("application/json")
    @Path("{times}/{input}")
    public Response get(@PathParam("times") int times, @PathParam("input") String input) {
        return Response.ok(dataGenerator.getData(times, input), MediaType.APPLICATION_JSON).build();
    }
}
