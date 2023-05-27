package com.cpms.services;

import com.cpms.model.RecruiterUser;

import java.util.List;

public interface RecruiterUserServices {
    void add(RecruiterUser user);
    void modify(RecruiterUser user);
    void removeById(int id);
    RecruiterUser getById(int id);


    boolean existsById(int id);

    RecruiterUser findByUsername(String username);

    List<RecruiterUser> getAllUsers();


}
