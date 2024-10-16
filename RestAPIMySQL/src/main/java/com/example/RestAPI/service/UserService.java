package com.example.RestAPI.service;

import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> obterTodos(){
        return userRepository.findAll();
    }

    public UserEntity obterPorId(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity inserir(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity atualizar(Long id, UserEntity newUser){
        UserEntity existingUser=userRepository.findById(id).orElse(null);
        if (existingUser!=null){
            existingUser.setUsername(newUser.getUsername());
            existingUser.setEmail(newUser.getEmail());
            return userRepository.save(existingUser);
        }else {
            return null;
        }
    }

    public  void excluir(Long id){
        userRepository.deleteById(id);
    }

    public List<UserEntity> buscarPorNome(String username){
        return userRepository.findByUsername(username);
    }


    public List<UserEntity> buscarPorEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<UserEntity> buscarPorNomeEEmail(String username,String email){
        return userRepository.findByUsernameAndEmail(username,email);
    }



}
