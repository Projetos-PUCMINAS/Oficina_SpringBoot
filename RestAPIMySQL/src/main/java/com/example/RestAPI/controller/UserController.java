package com.example.RestAPI.controller;

import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity>obterTodos(){
        return userService.obterTodos();
    }

    @GetMapping("/{id}")
    public UserEntity obterPorId(@PathVariable Long id){
        return  userService.obterPorId(id);
    }

    @PostMapping()
    public UserEntity inserir(@RequestBody UserEntity user){
        return userService.inserir(user);
    }

    @PutMapping("/{id}")
    public UserEntity atualizar(@PathVariable Long id, @RequestBody UserEntity user){
        return userService.atualizar(id, user);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        userService.excluir(id);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public List<UserEntity> buscarPorNome(@PathVariable String nome){
        return userService.buscarPorNome(nome);
    }

    @GetMapping("/buscarPorEmail/{email}")
    public List<UserEntity> buscarPorEmail(@PathVariable String email){
        return userService.buscarPorEmail(email);
    }

    @GetMapping("/buscarPorNomeEEmail")
    public List<UserEntity> buscarPorNomeEEmail(@RequestParam("nome") String nome,@RequestParam("email") String email){
        return userService.buscarPorNomeEEmail(nome,email);
    }
}
