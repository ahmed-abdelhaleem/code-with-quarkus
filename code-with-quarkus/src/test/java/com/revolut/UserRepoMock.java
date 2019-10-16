package com.revolut;

import com.revolut.repo.UserRepo;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;


@ApplicationScoped
@Alternative
@Priority(1)
public class UserRepoMock extends UserRepo {

}
