/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.DokterHelper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Dokter;

/**
 *
 * @author asus
 */
@Path("dokter")
public class DokterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of lokasiResource
     */
    public DokterResource() {
    }

    /**
     * Retrieves representation of an instance of services.lokasiResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        DokterHelper d = new DokterHelper();
        Gson gson = new Gson();
        return Response.status(Response.Status.OK)
                .entity(gson.toJson(d.bacaSemuaDokter()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "20")
                .header("Access-Preflight-Maxage", "20")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of lokasiResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addDokter")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response AddNewDokter(String data) {
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data, Dokter.class);
        DokterHelper helper = new DokterHelper();
        helper.addNewDokter(dokter.getNama(), dokter.getSpesialis());
        return Response.status(200).entity(dokter).build();
    }
}
