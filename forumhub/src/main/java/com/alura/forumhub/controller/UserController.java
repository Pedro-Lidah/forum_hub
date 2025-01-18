package com.alura.forumhub.controller;

import com.alura.forumhub.usuaio.DadosAtualizacao;
import com.alura.forumhub.usuaio.DadosUsuario;
import com.alura.forumhub.usuaio.UserRepository;
import com.alura.forumhub.usuaio.Usuario;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosUsuario dados){
        System.out.println(dados);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacao dados){
        var user = repository.getReferenceById(dados.id());
        user.atualizarinformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
