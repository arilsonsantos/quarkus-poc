package br.com.orion.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.orion.model.Todo;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    
    @GET
    public List<Todo> getAll(){
        return Todo.listAll();
    }

    @Transactional
    @POST
    public Response addOne(Todo item){
        item.persist();
        return Response.status(Status.CREATED).entity(item).build();
    }
}