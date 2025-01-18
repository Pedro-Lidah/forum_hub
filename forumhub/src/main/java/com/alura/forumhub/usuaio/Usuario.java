package com.alura.forumhub.usuaio;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String estado;
    private String autor;
    private String curso;

    public void atualizarinformacoes(@Valid DadosAtualizacao dados) {
       if (dados.titulo() != null){
        this.titulo = dados.titulo();
    }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.estado() != null){
            this.estado = dados.estado();
        }
        if (dados.autor() != null){
            this.autor = dados.autor();
        }
        if (dados.curso() != null){
            this.curso = dados.curso();
        }
}
