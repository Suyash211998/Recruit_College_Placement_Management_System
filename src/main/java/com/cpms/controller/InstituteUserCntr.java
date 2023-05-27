package com.cpms.controller;

import com.cpms.dao.InstituteUserDao;
import com.cpms.model.InstituteUser;
import com.cpms.services.InstituteUserServices;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class InstituteUserCntr {

    @Autowired
    private InstituteUserServices userServices;


    @PostMapping(value = {"/institute_user"})
    public String userAdd(@Valid @RequestBody InstituteUser user){
        userServices.add(user);
        return "Success";
    }


    @PutMapping(value = {"/institute_user"})
    public String userUpdate(@Valid @RequestBody InstituteUser user) {
        userServices.modify(user);
        return "success";
    }
    @DeleteMapping(value = {"/institute_user/{id}"})
    public String userDelete(@PathVariable int id) {
        InstituteUser user = userGet(id);
        userServices.removeById(id);
        return "success";
    }

    @GetMapping(value = {"/institute_user/{id}"})
    public InstituteUser userGet(@PathVariable int id) {
        return userServices.getById(id);
    }

    @GetMapping(value = {"/institute_user/username/{username}"})
    public InstituteUser getUsername(@PathVariable String username) {
        InstituteUser user = userServices.findUserByUsername(username);
        if(user == null){
            InstituteUser findUser = userServices.getById(-1);
        }

        return user;
    }


    @GetMapping(value = {"/institute_user"})
    public List<InstituteUser> users(){
        return userServices.findAllUsers();
    }


    //checking BCrypt password
    static private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            return true;
        }
        else {

            return false;
        }
    }

    //player table check for logged in email and password
    public InstituteUser userCheck(String username, String plainPassword ) {

        InstituteUser user = userServices.findUserByUsername(username);
        if (user != null) {
            String hashedPassword=user.getPassword();
            if(checkPass(plainPassword, hashedPassword)) {
                return user;
            }
        }
        return null;
    }

    @PostMapping(value= {"/institutelogin"})
    public InstituteUser userLogin(@RequestBody InstituteUser user ) {

        String username = user.getUsername();
        String plainPassword=user.getPassword();

        if(userCheck(username, plainPassword)!=null) {
            return userCheck(username, plainPassword);
        }
        else
            return null;
    }

    @GetMapping(value = {"/institute_user/clgname/{clgname}"})
    public int getClgname(@PathVariable String clgname) {
        InstituteUser user = userServices.findUserByClgName(clgname);
        return user.getInstituteId();
    }




}
