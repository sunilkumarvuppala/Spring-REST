package com.sunil.api.service.impl;

import com.sunil.api.entity.User;
import com.sunil.api.exception.BadRequestException;
import com.sunil.api.exception.NotFoundException;
import com.sunil.api.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sunil.api.respository.UserRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository repository;
    
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public User findOne(String id) {
        User existing = repository.findOne(id);
        if (existing == null) {
            //throw a runtime exception here which should return 404 to client
            throw new NotFoundException("User with id: " + id + " does not exist");
        }
        return existing;        
    }
    
    @Override
    @Transactional
    public User create(User user) {
        User existing = repository.findEmail(user.getEmail());
        if (existing != null) {
            //throw a runtime exception here which should return 400 to client
            //Bad request. Email already exists
            throw new BadRequestException("User with email: " + user.getEmail() + " already exist");
        }
        return repository.create(user);
    }
    
    @Override
    @Transactional
    public User update(String id, User user) {
        User existing = repository.findOne(id);
        if (existing == null) {
            //throw a runtime exception here which should return 404 to client
            throw new NotFoundException("User with id: " + id + " does not exist");
        }
        return repository.update(existing);        
    }
    
    @Override
    @Transactional
    public void delete(String id) {
        User existing = repository.findOne(id);
        if (existing == null) {
            //throw a runtime exception here which should return 404 to client
            throw new NotFoundException("User with id: " + id + " does not exist");
        }
        repository.delete(existing);
    }
    
}
