package com.example.RestAPI.service;

import com.example.RestAPI.controller.UserController;
import com.example.RestAPI.model.UserEntity;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {com.example.RestAPI.aplication.RestApiApplication.class})
class UserServiceTest {

    @Mock
    private  UserService userService;

    @InjectMocks
    private UserController userController;
    private  UserEntity user;
    private  UserEntity user2;

    @BeforeEach
    void setUp() {
        user=new UserEntity("marcosalberto@gmail.com","Marcos","mar");
        user2=new UserEntity("bernardoalvim@gmail.com","Bernardo","ber");
    }

    @Test
    void obterTodos() {
        List<UserEntity> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user2);

        when(userService.obterTodos()).thenReturn(userList);

        List<UserEntity> result=userController.obterTodos();
        assertEquals(userList,result);
    }

    @Test
    void obterPorId() {
        when(userService.obterPorId(user.getId())).thenReturn(user);

        UserEntity result=userController.obterPorId(user.getId());
        assertEquals(user,result);
    }

    @Test
    void inserir() {
        when(userService.inserir(user)).thenReturn(user);
        UserEntity result=userController.inserir(user);
        assertEquals(user,result);
    }

    @Test
    void atualizar() {
        when(userService.atualizar(1L, user)).thenReturn(user);
        UserEntity result=userController.atualizar(1L, user);
        assertEquals(user,result);
    }

    @Test
    void excluir() {
        doNothing().when(userService).excluir(user.getId());
        userController.excluir(user.getId());
        verify(userService,times(1)).excluir(user.getId());
    }

    @Test
    void buscarPorNome() {
        List<UserEntity> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        when(userService.buscarPorNome("Marcos")).thenReturn(userList);

        List<UserEntity> result=userController.buscarPorNome(user.getUsername());
        assertEquals(userList,result);
    }

    @Test
    void buscarPorEmail() {
        List<UserEntity> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        when(userService.buscarPorEmail("marcosalberto@gmail.com")).thenReturn(userList);
        List<UserEntity> result=userController.buscarPorEmail(user.getEmail());
        assertEquals(userList,result);
    }

    @Test
    void buscarPorNomeEEmail() {
        List<UserEntity> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        when(userService.buscarPorNomeEEmail("Marcos","marcosalberto@gmail.com")).thenReturn(userList);
        List<UserEntity> result=userController.buscarPorNomeEEmail(user.getUsername(),user.getEmail());
        assertEquals(userList,result);
    }
}