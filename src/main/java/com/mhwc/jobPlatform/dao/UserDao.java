package com.mhwc.jobPlatform.dao;


import com.mhwc.jobPlatform.model.User;

public interface UserDao {

    public User findByUserName(String userName);

    public User save(User user);

    public User findByEmail(String email);

    public User findById(Long id);

    public User findByEmailAndPhoneNumber(String email, String phoneNumber);

}
