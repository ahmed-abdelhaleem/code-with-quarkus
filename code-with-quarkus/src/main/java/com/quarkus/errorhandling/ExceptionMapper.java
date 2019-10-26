package com.quarkus.errorhandling;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ProcessingException> {

    @Context
    HttpHeaders headers;

    @Override
    public Response toResponse(ProcessingException e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(),e.getMessage());
        return Response
                .status(e.getHttpStatus())
                .entity(errorResponse)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .build();
    }
}