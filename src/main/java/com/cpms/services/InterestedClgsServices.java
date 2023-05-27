package com.cpms.services;

import com.cpms.model.InterestedClgs;

import java.util.List;

public interface InterestedClgsServices {

    void addClg(InterestedClgs clg);

    void modifyClg(InterestedClgs clg);

    void removeById(int id);

    InterestedClgs getById(int id);

    List<InterestedClgs> getAllClgs();

    List<InterestedClgs> getAllJobId(int id);
}
