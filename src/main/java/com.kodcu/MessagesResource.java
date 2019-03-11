package com.kodcu;

import javax.json.Json;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("messages")
public class MessagesResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public Message message(@PathParam("id") long id) {
        return new Message("hello from message " + id);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> myMessages() {

        List<Message> messages = new ArrayList<>();
        messages.add(new Message("duke"));
        messages.add(new Message("devo"));
        messages.add(new Message("kodcu dev"));
        return messages;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject jsonMessage() {
        Message message = new Message("hello from message");
        return Json.createObjectBuilder().add("1", message.toString()).build();
        //return new Message("hello from message");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(@Valid  Message message ) {
        System.out.println(" Message : " + message );
    }
}
