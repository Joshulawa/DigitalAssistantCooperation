package com.example.demo.service;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserCanUse {

    private final UserRepository userRepository;

    public UserCanUse(UserRepository userRepository) {this.userRepository = userRepository;}

    public Iterable<User> list() {return userRepository.findAll();}
    public void save(List<User> users) {
        userRepository.saveAll(users);
    }
    public User save(User user){
        return userRepository.save(user);
    }


}