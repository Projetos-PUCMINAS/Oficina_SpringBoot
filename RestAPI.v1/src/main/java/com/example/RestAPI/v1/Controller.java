package com.example.RestAPI.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @GetMapping("/test")
  public String helloWorld() {
    return "Essa é minha primeira API REST";
  }
  
    @GetMapping("/login")
    public String login() {
      return "Aqui será meu login";
    }

  @GetMapping("/cadastro")
  public String cad() {
    return "aqui é cadastro";
  }

  @GetMapping("/update")
  public String update() {
    return "aqui é update";
  }
}
