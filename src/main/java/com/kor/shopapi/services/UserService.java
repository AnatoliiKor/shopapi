package com.kor.shopapi.services;

import com.kor.shopapi.domain.Role;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername (String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean addUser(User user){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb !=null) {
            return false;
        }
        user.setActive(true);
        user.setRegistrationDate();
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return true;
    }
}

