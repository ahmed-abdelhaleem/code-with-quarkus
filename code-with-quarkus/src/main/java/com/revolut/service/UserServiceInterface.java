package com.revolut.service;

import com.revolut.dto.CreateUserDTO;
import com.revolut.errorhandling.ProcessingException;

import javax.ws.rs.core.Response;

public interface UserServiceInterface {

    Response getUserInfo(Long userId) throws ProcessingException;

    Response createUser(CreateUserDTO createUserDTO) throws ProcessingException;
}
