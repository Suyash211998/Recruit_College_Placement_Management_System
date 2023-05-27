package com.cpms.services;

import com.cpms.dao.InstituteUserDao;
import com.cpms.exceptions.GlobalExceptionHandler;
import com.cpms.exceptions.ResourceNotFoundException;
import com.cpms.model.InstituteUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituteUserServicesImpl implements InstituteUserServices {


    @Autowired
    private InstituteUserDao userDao;

    @Override
    public void add(InstituteUser user) {
        String encPassword = hashPassword(user.getPassword());
        user.setPassword(encPassword);
        userDao.save(user);
    }
    @Override
    public InstituteUser changePassword(InstituteUser user) {
        InstituteUser mainUser = userDao.getById(user.getInstituteId());
        return mainUser;

    }

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    @Override
    public void modify(InstituteUser user) {
        userDao.save(user);
    }

    @Override
    public void removeById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public InstituteUser getById(int id) {
        InstituteUser opt = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
        
        return opt;
    }

    @Override
    public boolean existsById(int id) {
        return userDao.existsById(id);
    }

    @Override
    public InstituteUser findUserByUsername(String username)  throws ResourceNotFoundException {

        InstituteUser user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public List<InstituteUser> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public InstituteUser findUserByClgName(String clgName) {

        return userDao.findByClgName(clgName);
    }
}
