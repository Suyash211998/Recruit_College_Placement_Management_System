package com.cpms.dao;

import com.cpms.model.InstituteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteUserDao extends JpaRepository<InstituteUser, Integer> {
    public InstituteUser findByUsername(@Param(value = "username") String username);

    public InstituteUser findByClgName(@Param(value = "clgName") String clgName);

}
