package com.revolut.controller;

import com.revolut.dto.CreateUserDTO;
import com.revolut.errorhandling.ProcessingException;
import com.revolut.service.UserServiceInterface;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/users")
public class UserResource {

    @Inject
    UserServiceInterface userService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo(@PathParam("id")Long id) throws ProcessingException {
        return userService.getUserInfo(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createUser(CreateUserDTO createUserDTO) throws ProcessingException {
        return userService.createUser(createUserDTO);
    }
}