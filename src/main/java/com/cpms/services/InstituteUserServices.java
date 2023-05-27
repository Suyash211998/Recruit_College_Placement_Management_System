package com.cpms.services;

import com.cpms.model.InstituteUser;

import java.util.List;

public interface InstituteUserServices {
    void add(InstituteUser user);
    void modify(InstituteUser user);
    void removeById(int id);
    InstituteUser getById(int id);

    boolean existsById(int id);

    InstituteUser findUserByUsername(String username);

    List<InstituteUser> findAllUsers();

    InstituteUser findUserByClgName(String clgName);

    InstituteUser changePassword(InstituteUser user);



}
