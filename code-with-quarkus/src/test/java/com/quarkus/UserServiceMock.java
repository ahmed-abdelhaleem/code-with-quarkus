package com.quarkus;

import com.quarkus.dto.CreateUserDTO;
import com.quarkus.dto.UserDTO;
import com.quarkus.errorhandling.ProcessingException;
import com.quarkus.service.UserServiceInterface;
import io.quarkus.test.Mock;
import org.apache.http.HttpStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@Mock
@ApplicationScoped
public class UserServiceMock implements UserServiceInterface {
    @Override
    public Response getUserInfo(Long userId) throws ProcessingException {
        if(userId==1 || userId==2){
        return Response.status(HttpStatus.SC_OK)
                .entity(getUserDTo("ahmed","ah@gmail.com")).build();
        }else {
            return Response.status(HttpStatus.SC_BAD_REQUEST).build();
        }
    }

    @Override
    public Response createUser(CreateUserDTO createUserDTO) throws ProcessingException {

        return Response.status(HttpStatus.SC_CREATED)
                .entity(getUserDTo(createUserDTO.getName(),createUserDTO.getEmail())).build();
    }

    private UserDTO getUserDTo(String name,String email){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setEmail(email);
        return userDTO;
    }
}
