package com.sunil.api.respository;

import com.sunil.api.entity.User;
import java.util.List;

public interface UserRepository {

    public List<User> findAll();

    public User findOne(String id);
    
    public User findEmail(String email);

    public User create(User user);

    public User update(User user);

    public void delete(User user);
}
