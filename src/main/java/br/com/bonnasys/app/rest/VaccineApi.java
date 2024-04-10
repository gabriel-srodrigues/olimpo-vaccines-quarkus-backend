package br.com.bonnasys.app.rest;


import br.com.bonnasys.app.rest.request.CreateVaccineRequest;
import br.com.bonnasys.app.rest.response.GetVaccineResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "Vaccines")
@Path("vaccines")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public interface VaccineApi {

    @POST
    @APIResponse(
            responseCode = "201",
            name = "Criar vacinas",
            description = "criar vacinas pelo nome e produtor",
            headers = @Header(
                    description = "Location of resource",
                    name = "Location",
            schema = @Schema(example = "/vaccines/{id}")),
            content = @Content(
                    schema = @Schema(implementation = GetVaccineResponse.class)))
    Response create(@Valid CreateVaccineRequest request);

    @GET
    Response search();

    @GET
    @Path("{id}")
    Response getById(@PathParam("id") String id);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") String id);
}
