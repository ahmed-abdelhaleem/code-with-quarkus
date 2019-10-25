package com.revolut.service;

import com.revolut.dto.CreateUserDTO;
import com.revolut.dto.UserDTO;
import com.revolut.errorhandling.ProcessingException;
import com.revolut.model.User;
import com.revolut.repo.UserRepo;
import org.apache.http.HttpStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.Date;

@ApplicationScoped
// same as Spring boot @Component
public class UserService implements UserServiceInterface {

    @Inject
    UserRepo userRepo;

    @Override
    public Response getUserInfo(Long userId) throws ProcessingException {
        User user = userRepo.findById(userId);
        if (user == null) {
            throw new ProcessingException("User not found", HttpStatus.SC_BAD_REQUEST);
        }
        return Response.status(HttpStatus.SC_OK).entity(getUserDTOFromUser(user)).build();
    }

    @Override
    @Transactional
    public Response createUser(CreateUserDTO createUserDTO) throws ProcessingException {

        if (userRepo.findByEmail(createUserDTO.getEmail()) != null) {
            throw new ProcessingException("User already registered", HttpStatus.SC_BAD_REQUEST);
        }
        User user = createUserModel(createUserDTO);
        userRepo.save(user);
        return Response.status(HttpStatus.SC_CREATED).entity(getUserDTOFromUser(user)).build();
    }

    private UserDTO getUserDTOFromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setLastRetrivalDate(new Date());
        return userDTO;
    }

    private User createUserModel(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        return user;
    }
}