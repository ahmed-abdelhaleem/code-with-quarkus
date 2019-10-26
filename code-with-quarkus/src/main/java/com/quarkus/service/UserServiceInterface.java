package com.quarkus.service;

import com.quarkus.dto.CreateUserDTO;
import com.quarkus.errorhandling.ProcessingException;

import javax.ws.rs.core.Response;

public interface UserServiceInterface {

    Response getUserInfo(Long userId) throws ProcessingException;

    Response createUser(CreateUserDTO createUserDTO) throws ProcessingException;
}
