package com.quarkus.dto;

import java.util.Date;

public class UserDTO {

    private String name;

    private String email;

    private Date lastRetrivalDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastRetrivalDate() {
        return lastRetrivalDate;
    }

    public void setLastRetrivalDate(Date lastRetrivalDate) {
        this.lastRetrivalDate = lastRetrivalDate;
    }
}
