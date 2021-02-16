package com.kor.shopapi.services;

import com.kor.shopapi.domain.Product;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return (List<User>) userRepository.findAll();
    }

    public void deleteByUserName(Long id) {
        userRepository.deleteById(id);
    }

}

