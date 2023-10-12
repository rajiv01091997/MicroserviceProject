package com.globallogic.Services;



import com.globallogic.Entity.User;

import java.util.List;

public interface UserService<User> {

    public com.globallogic.Entity.User saveUser(com.globallogic.Entity.User user);
    public List<User> getAllUser();
    public User getUser(String UserId);
    public String deleteUser(String UserId);
    public User updateUser(String UserId);

}
