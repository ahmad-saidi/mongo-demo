package com.training.mongo.demo.service;

import com.training.mongo.demo.model.dto.UserDTO;
import com.training.mongo.demo.model.enity.UserEntity;
import com.training.mongo.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDTO> getAll(){
        return userRepository.findAll().stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .toList();
    }


    public UserDTO getById(String id){
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElse(null);
    }

    public UserDTO adduser(UserDTO userDTO){
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setId(UUID.randomUUID().toString());
        return modelMapper.map(userRepository.insert(userEntity), UserDTO.class);

    }


}
