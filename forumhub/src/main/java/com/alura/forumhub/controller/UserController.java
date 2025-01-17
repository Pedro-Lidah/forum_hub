package com.alura.forumhub.controller;

import com.alura.forumhub.usuaio.DadosUsuario;
import com.alura.forumhub.usuaio.UserRepository;
import com.alura.forumhub.usuaio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosUsuario dados){
        System.out.println(dados);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }
}
