package com.cpms.controller;

import com.cpms.model.InstituteStudents;
import com.cpms.model.RecruiterUser;
import com.cpms.services.InstituteStudentServices;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class InstituteStudentCntr {

    @Autowired
    private InstituteStudentServices services;

    @PostMapping(value= {"/student"})
    public String addStudent(@Valid @RequestBody InstituteStudents student){
        services.add(student);
        return "Success";
    }

    @PutMapping(value= {"/student"})
    public String updateStudent(@Valid @RequestBody InstituteStudents student){
        services.modify(student);
        return "success";
    }

    @DeleteMapping(value={"/student/{id}"})
    public String deleteStudent(@PathVariable int id){
        InstituteStudents user = studentById(id);
        services.removeById(id);
        return "success";
    }

    @GetMapping(value={"/student/{id}"})
    public InstituteStudents studentById(@PathVariable int id){
        return services.getById(id);
    }

    @GetMapping(value={"/student/byusername/{username}"})
    public InstituteStudents studentByUsername(@PathVariable String username){
        return services.findUserByUsername(username);
    }

    @GetMapping(value={"/student"})
    public List<InstituteStudents> allStudents(){
        return services.findAllUsers();
    }

    static private boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            return true;
        }
        else {
            return false;
        }
    }
    public InstituteStudents userCheck(String username, String plainPassword ) {

        InstituteStudents user = services.findUserByUsername(username);
        if (user != null) {
            String hashedPassword=user.getPassword();
            if(checkPass(plainPassword, hashedPassword)) {
                return user;
            }
        }
        return null;
    }

    @PostMapping(value= {"/studentlogin"})
    public InstituteStudents userLogin(@RequestBody InstituteStudents user ) {

        String username = user.getUsername();
        String plainPassword=user.getPassword();

        if(userCheck(username, plainPassword)!=null) {
            return userCheck(username, plainPassword);
        }
        else
            return null;
    }

    @GetMapping(value={"/student/getinstitute/{institute}"})
    public List<InstituteStudents> allInstituteStudents(@PathVariable String institute){
        return services.findAllByInstitute(institute);
    }

}
