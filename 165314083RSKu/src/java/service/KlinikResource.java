/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.Klinikhelper;
import helper.LokasiHelper;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Klinik;

/**
 *
 * @author asus
 */
@Path("klinik")
public class KlinikResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of lokasiResource
     */
    public KlinikResource() {
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
        Klinikhelper k = new Klinikhelper();
        Gson gson = new Gson();
        return Response.status(Response.Status.OK)
                .entity(gson.toJson(k.bacaSemuaLokasi()))
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
@Path("addKlinik")
 @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public Response AddNewKlinik(String data){
    Gson gson=new Gson();
    Klinik klinik= gson.fromJson(data,Klinik.class);
    Klinikhelper helper =new Klinikhelper();
    helper.addNewKlinik(klinik.getIdKlinik(),klinik.getNama(),klinik.getSpesialis());
    return Response.status(200).entity(klinik).build();
}

}
