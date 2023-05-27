package com.cpms.services;


import com.cpms.dao.RecruiterUserDao;
import com.cpms.exceptions.ResourceNotFoundException;
import com.cpms.model.RecruiterUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterUserServicesImpl implements RecruiterUserServices {



    @Autowired
    private RecruiterUserDao userDao;

    @Override
    public void add(RecruiterUser user) {
        String encPassword = hashPassword(user.getPassword());
        user.setPassword(encPassword);
        userDao.save(user);
    }

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    @Override
    public void modify(RecruiterUser user) {
        userDao.save(user);
    }

    @Override
    public void removeById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public RecruiterUser getById(int id) {
        RecruiterUser opt = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
        return opt;
    }

    @Override
    public boolean existsById(int id) {
        return userDao.existsById(id);
    }


    @Override
    public RecruiterUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<RecruiterUser> getAllUsers() {
        return userDao.findAll();
    }
}
