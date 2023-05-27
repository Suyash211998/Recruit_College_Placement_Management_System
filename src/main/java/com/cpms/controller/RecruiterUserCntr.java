package com.cpms.controller;

import com.cpms.model.InstituteUser;
import com.cpms.model.RecruiterUser;
import com.cpms.services.RecruiterUserServices;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecruiterUserCntr {

    @Autowired
    private RecruiterUserServices userServices;

    @PostMapping(value = {"/recruiter_user"})
    public String userAdd(@Valid @RequestBody RecruiterUser user){
        userServices.add(user);
        return "Success";
    }


    @PutMapping(value = {"/recruiter_user"})
    public String userUpdate(@Valid @RequestBody RecruiterUser user) {
        userServices.modify(user);
        return "success";
    }
    @DeleteMapping(value = {"/recruiter_user/{id}"})
    public String userDelete(@PathVariable int id) {
        RecruiterUser user = userGet(id);
        userServices.removeById(id);
        return "success";
    }

    @GetMapping(value = {"/recruiter_user/{id}"})
    public RecruiterUser userGet(@PathVariable int id) {
        return userServices.getById(id);
    }

    @GetMapping(value = {"/recruiter_user/byusername/{username}"})
    public RecruiterUser userListByUsername(@PathVariable String username){
        return userServices.findByUsername(username);
    }


    @GetMapping(value = {"/recruiter_user"})
    public List<RecruiterUser> allUser(){
        return userServices.getAllUsers();
    }


    static private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            return true;
        }
        else {
            return false;
        }
    }
    public RecruiterUser userCheck(String username, String plainPassword ) {

        RecruiterUser user = userServices.findByUsername(username);
        if (user != null) {
            String hashedPassword=user.getPassword();
            if(checkPass(plainPassword, hashedPassword)) {
                return user;
            }
        }
        return null;
    }

    @PostMapping(value= {"/recruiterlogin"})
    public RecruiterUser userLogin(@RequestBody RecruiterUser user ) {

        String username = user.getUsername();
        String plainPassword=user.getPassword();

        if(userCheck(username, plainPassword)!=null) {
            return userCheck(username, plainPassword);
        }
        else
            return null;
    }


}
