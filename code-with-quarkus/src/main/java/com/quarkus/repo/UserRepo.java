package com.quarkus.repo;

import com.quarkus.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserRepo implements PanacheRepositoryBase<User,Long> {

    public User findByName(String name) {
        return find("name", name).firstResult();
    }

    public User findByEmail(String email) {
        return find("email", email).firstResult();
    }

    @Transactional
    public void save(User user){
        user.persist();
    }

}
