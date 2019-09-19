package com.jerseycrud.demo.jerseycrud.service;

import com.jerseycrud.demo.jerseycrud.domain.User;
import com.jerseycrud.demo.jerseycrud.dto.UserDTO;
import com.jerseycrud.demo.jerseycrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insert(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public User update(UserDTO userDTO,Long id){
        User user = userRepository.findOne(id);
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getOne(Long id){
        return userRepository.findOne(id);
    }

}
